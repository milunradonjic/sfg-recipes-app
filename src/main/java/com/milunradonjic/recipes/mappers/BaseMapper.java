package com.milunradonjic.recipes.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

/**
 * Map Entity to DTO
 * Map DTO to Entity
 *
 * @param <D> DTO
 * @param <E> Entity
 */
public interface BaseMapper<D, E> {

    String TO_DTO = "TO_DTO";
    String TO_ENTITY = "TO_ENTITY";

    @Named(TO_DTO)
    D toDto(E entity);

    @IterableMapping(qualifiedByName = TO_DTO)
    Set<D> toDto(Set<E> entity);

    @IterableMapping(qualifiedByName = TO_DTO)
    List<D> toDto(List<E> entity);


    @Named(TO_ENTITY)
    E toEntity(D dto);

    @IterableMapping(qualifiedByName = TO_ENTITY)
    Set<E> toEntity(Set<D> dto);

    @IterableMapping(qualifiedByName = TO_ENTITY)
    List<E> toEntity(List<D> dto);
}
