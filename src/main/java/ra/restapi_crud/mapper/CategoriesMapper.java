package ra.restapi_crud.mapper;

import org.springframework.stereotype.Component;
import ra.restapi_crud.dto.request.CategoriesDTORequest;
import ra.restapi_crud.dto.response.CategoriesDTOResponse;
import ra.restapi_crud.model.Categories;

@Component
public class CategoriesMapper implements GenericMapper<Categories, CategoriesDTORequest, CategoriesDTOResponse> {
    @Override
    public Categories mapperRequestToEntity(CategoriesDTORequest categoriesDTORequest) {
        return Categories.builder().id(categoriesDTORequest.getId())
                .name(categoriesDTORequest.getName())
                .priority(categoriesDTORequest.getPriority())
                .descriptions(categoriesDTORequest.getDescriptions())
                .status(categoriesDTORequest.isStatus()).build();
    }

    @Override
    public CategoriesDTOResponse mapperEntityToResponse(Categories categories) {
        return new CategoriesDTOResponse(
                categories.getId(),
                categories.getName(),
                categories.getPriority(),
                categories.getDescriptions(),
                categories.isStatus()
        );
    }
}
