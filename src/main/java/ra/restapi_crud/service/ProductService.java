package ra.restapi_crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.restapi_crud.dto.response.ProductDTOResponse;
import ra.restapi_crud.model.Product;

import java.util.Map;

public interface ProductService {
    //1.Dịch vụ cho phép lấy tất cả các sản phẩm có phân trang
    Map<String, Object> findAll(int page, int size);

    //2.Dịch vụ cho phep tìm kiếm sản phẩm theo tên sản phẩm có phân trang
    Map<String, Object> findByName(int page, int size, String productName);

    //3.Dịch vụ cho phép tìm kiếm sản phẩm theo tên sản phẩm và giá sản phẩm
    //trong khoảng từ fromPrice đến toPrice có phân trang
    Map<String, Object> findByNameOrPrice(int page, int size, String productName, float fromPrice, float toPrice);

    //4. Dịch vụ cho phep tìm kiếm san phẩm theo tên sản phẩm và giá sản phẩm
    //trong khoảng từ fromPrice đến toPrice có sắp xếp theo tên hoặc giá (giảm dần/tăng dần)
    Map<String, Object> findByNameOrPriceOrder(int page, int size, String productName, float fromPrice,
                                              float toPrice, String direction, String orderBy);
}
