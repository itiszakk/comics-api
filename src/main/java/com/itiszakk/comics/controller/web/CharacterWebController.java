package com.itiszakk.comics.controller.web;

import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.domain.repository.Filter;
import com.itiszakk.comics.domain.repository.SearchOperation;
import com.itiszakk.comics.dto.Character;
import com.itiszakk.comics.service.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@PropertySource("classpath:controller-config.properties")
@RequestMapping("${controller.web.character.domain}")
public class CharacterWebController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${controller.web.character.domain}")
    private String controllerDomain;

    private final List<String> alignmentTypeList;
    private final List<String> publisherNameList;

    private CharacterFilterForm form;

    private final CharacterService service;

    @Autowired
    public CharacterWebController(CharacterService service) {
        this.service = service;

        alignmentTypeList = CharacterAlignment.getTypeList();
        publisherNameList = ComicsPublisher.getNameList();

        form = new CharacterFilterForm();
    }

    @GetMapping
    public String getCharacters(Model model) {
        List<Character> characterList = getCharactersByWebFilter();

        //form.reset();

        model.addAttribute("applicationName", applicationName);
        model.addAttribute("controllerDomain", controllerDomain);
        model.addAttribute("idField", Character.Fields.id);
        model.addAttribute("characterNameField", Character.Fields.characterName);
        model.addAttribute("alignmentField", Character.Fields.alignment);
        model.addAttribute("publisherField", Character.Fields.publisher);
        model.addAttribute("alignmentTypeList", alignmentTypeList);
        model.addAttribute("publisherNameList", publisherNameList);
        model.addAttribute("filterForm", form);
        model.addAttribute("characterList", characterList);

        return "characters";
    }

    @PostMapping
    public String filterHandler(CharacterFilterForm form) {
        this.form = form;
        return "redirect:/characters";
    }

    @GetMapping(value = "/{id}")
    public String getCharacterById(@PathVariable Integer id, Model model) {
        Optional<Character> optionalCharacter = service.getById(id);

        if (optionalCharacter.isEmpty()) {
            return "error";
        }

        model.addAttribute("applicationName", applicationName);
        model.addAttribute("controllerDomain", controllerDomain);
        model.addAttribute("character", optionalCharacter.get());

        return "character-info";
    }

    private List<Character> getCharactersByWebFilter() {
        List<Filter> filterList = new ArrayList<>();

        if (form.getAlignments() != null && form.getAlignments().size() > 0) {
            Filter alignmentFilter = Filter.builder()
                    .key(Character.Fields.alignment)
                    .operation(SearchOperation.IN)
                    .values(toObjectList(form.getAlignments()))
                    .build();

            filterList.add(alignmentFilter);
        }

        if (form.getPublishers() != null && form.getPublishers().size() > 0) {
            Filter publisherFilter = Filter.builder()
                    .key(Character.Fields.publisher)
                    .operation(SearchOperation.IN)
                    .values(toObjectList(form.getPublishers()))
                    .build();

            filterList.add(publisherFilter);
        }

        if (form.getNameStartsWith() != null && form.getNameStartsWith().length() > 0) {
            Filter nameStartsWithFilter = Filter.builder()
                    .key(Character.Fields.characterName)
                    .operation(SearchOperation.LIKE)
                    .value(form.getNameStartsWith())
                    .build();

            filterList.add(nameStartsWithFilter);
        }

        Sort sort = Sort.by(form.getSortField());

        return (filterList.size() == 0)
                ? service.getAll(sort)
                : service.getAll(filterList, sort);
    }

    private List<Object> toObjectList(List<String> list) {
        return list.stream().map(x -> ((Object) x)).toList();
    }
}
