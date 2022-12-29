
package com.project.be.api.mapper;

import java.util.List;

public interface IGenericMapper<D, E> {
    D mapToDTO(E e);

    E mapToEntity(D d);

    List<D> mapToListDTO(List<E> eList);

    List<E> mapToListEntity(List<D> dList);

}

