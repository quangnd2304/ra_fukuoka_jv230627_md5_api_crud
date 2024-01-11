package ra.restapi_crud.service;

import ra.restapi_crud.dto.request.CategoriesDTORequest;
import ra.restapi_crud.dto.response.CategoriesDTOResponse;

import java.util.List;

public interface CategoriesService {
    List<CategoriesDTOResponse> findAll();

    CategoriesDTOResponse findById(int id);

    CategoriesDTOResponse save(CategoriesDTORequest categoriesDTORequest);

    CategoriesDTOResponse update(CategoriesDTORequest categoriesDTORequest, int id);

    boolean delete(int id);

    List<CategoriesDTOResponse> find(String direction, String orderBy, int page, int size);
}
