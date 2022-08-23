package com.itiszakk.comics.repository;

import com.itiszakk.comics.domain.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CharacterEntitySpecification implements Specification<CharacterEntity> {
    private List<SearchCriteria> criteriaList;

    public CharacterEntitySpecification() {
        this.criteriaList = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        criteriaList.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<CharacterEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicateList = new ArrayList<>();

        for (SearchCriteria criteria : criteriaList) {
            if (criteria.getValue() == null) {
                continue;
            }

            if (criteria.getOperation() == SearchOperation.EQUAL) {
                predicateList.add(
                        builder.equal(root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation() == SearchOperation.LIKE) {
                predicateList.add(
                        builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%"));
            }
        }

        return builder.and(predicateList.toArray(new Predicate[0]));
    }
}
