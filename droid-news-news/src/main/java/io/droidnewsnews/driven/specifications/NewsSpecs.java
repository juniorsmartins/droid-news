package io.droidnewsnews.driven.specifications;

import io.droidnewsnews.core.domain.filters.NewsFilter;
import io.droidnewsnews.driven.daos.NewsDAO;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;

public final class NewsSpecs {

  public static Specification<NewsDAO> queryDynamically(NewsFilter filter) {

    return ((root, query, criteriaBuilder) -> {

      var predicates = new ArrayList<Predicate>();

      if (ObjectUtils.isNotEmpty(filter.id())) {
        predicates.add(criteriaBuilder.equal(root.get("id"), filter.id()));
      }

      if (ObjectUtils.isNotEmpty(filter.hat())) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("hat")),
          "%".concat(filter.hat().toLowerCase()).concat("%")));
      }

      if (ObjectUtils.isNotEmpty(filter.title())) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
          "%".concat(filter.title().toLowerCase()).concat("%")));
      }

      if (ObjectUtils.isNotEmpty(filter.caption())) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("caption")),
          "%".concat(filter.caption().toLowerCase()).concat("%")));
      }

      if (ObjectUtils.isNotEmpty(filter.body())) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("body")),
          "%".concat(filter.body().toLowerCase()).concat("%")));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    });
  }
}

