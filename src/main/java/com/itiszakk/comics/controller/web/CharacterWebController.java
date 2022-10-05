package com.itiszakk.comics.controller.web;

import com.itiszakk.comics.controller.ControllerUtils;
import com.itiszakk.comics.domain.entity.character.CharacterAlignment;
import com.itiszakk.comics.domain.entity.character.ComicsPublisher;
import com.itiszakk.comics.dto.Character;
import com.itiszakk.comics.service.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@PropertySource("classpath:controller-config.properties")
@RequestMapping("${controller.web.character.domain}")
public class CharacterWebController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${controller.web.character.domain}")
    private String controllerDomain;

    private final CharacterService service;

    @Autowired
    public CharacterWebController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    String getAllCharacters(Model model) {
        Optional<Sort> optionalSort = ControllerUtils.getSortOrThrowException(Character.Fields.id);

        List<Character> characterList = (optionalSort.isEmpty())
                ? service.getAll()
                : service.getAll(optionalSort.get());

        Map<String, List<String>> filterValues = new HashMap<>();
        filterValues.put(Character.Fields.alignment, CharacterAlignment.getTypeList());
        filterValues.put(Character.Fields.publisher, ComicsPublisher.getNameList());

        model.addAttribute("applicationName", applicationName);
        model.addAttribute("controllerDomain", controllerDomain);
        model.addAttribute("filterValues", filterValues);
        model.addAttribute("characters", characterList);

        return "characters";
    }

    @GetMapping(value = "/{id}")
    String getCharacterById(@PathVariable Integer id, Model model) {
        Optional<Character> optionalCharacter = service.getById(id);

        if (optionalCharacter.isEmpty()) {
            return "error";
        }

        model.addAttribute("applicationName", applicationName);
        model.addAttribute("controllerDomain", controllerDomain);
        model.addAttribute("character", optionalCharacter.get());

        return "character-info";
    }
}
