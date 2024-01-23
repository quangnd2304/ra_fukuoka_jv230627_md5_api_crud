package ra.restapi_crud.mapper;

import org.springframework.stereotype.Component;
import ra.restapi_crud.dto.response.ProductDTOResponse;
import ra.restapi_crud.model.Product;
@Component
public class ProductMapper implements GenericMapper<Product,Product, ProductDTOResponse>{
    @Override
    public Product mapperRequestToEntity(Product product) {
        return null;
    }

    @Override
    public ProductDTOResponse mapperEntityToResponse(Product product) {
        return new ProductDTOResponse(
                product.getId(), product.getName(), product.getPrice(),
                product.isStatus(),product.getCatalog().getId(),product.getCatalog().getName()
        );
    }
}
