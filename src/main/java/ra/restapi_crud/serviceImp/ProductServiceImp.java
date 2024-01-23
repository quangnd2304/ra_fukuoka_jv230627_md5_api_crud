package ra.restapi_crud.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.restapi_crud.dto.response.ProductDTOResponse;
import ra.restapi_crud.mapper.ProductMapper;
import ra.restapi_crud.model.Product;
import ra.restapi_crud.repository.ProductRepository;
import ra.restapi_crud.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Map<String, Object> findAll(int page, int size) {
        //Tạo 1 đối tượng Pageable để phân trang
        Pageable pageable = PageRequest.of(page, size);
        //Gọi findAll của JpaRepository để lấy các sản phẩm có phân trang
        Page<Product> pageProduct = productRepository.findAll(pageable);
        //Lấy tổng số trang trong kết quả
        int totalPage = pageProduct.getTotalPages();
        //Lấy dữ liệu sản phẩm trên 1 trang
        List<Product> listProduct = pageProduct.getContent();
        //Chuyển từ listProduct sang listProductDTOResponse
        List<ProductDTOResponse> listProductDTOResponse = listProduct.stream()
                .map(product -> productMapper.mapperEntityToResponse(product))
                .collect(Collectors.toList());
        //Khởi tạo Map để trả về cho client
        Map<String, Object> data = new HashMap<>();
        //tổng số trang khi phân trang
        data.put("totalPage", totalPage);
        //Dữ liệu trên 1 trang
        data.put("products", listProductDTOResponse);
        return data;
    }

    @Override
    public Map<String, Object> findByName(int page, int size, String productName) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pageProduct = productRepository.findByNameContains(productName, pageable);
        //Lấy tổng số trang trong kết quả
        int totalPage = pageProduct.getTotalPages();
        //Lấy dữ liệu sản phẩm trên 1 trang
        List<Product> listProduct = pageProduct.getContent();
        //Chuyển từ listProduct sang listProductDTOResponse
        List<ProductDTOResponse> listProductDTOResponse = listProduct.stream()
                .map(product -> productMapper.mapperEntityToResponse(product))
                .collect(Collectors.toList());
        //Khởi tạo Map để trả về cho client
        Map<String, Object> data = new HashMap<>();
        //tổng số trang khi phân trang
        data.put("totalPage", totalPage);
        //Dữ liệu trên 1 trang
        data.put("products", listProductDTOResponse);
        return data;
    }

    @Override
    public Map<String, Object> findByNameOrPrice(int page, int size, String productName, float fromPrice, float toPrice) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pageProduct = productRepository.findByNameContainsAndPriceBetween(productName, fromPrice, toPrice, pageable);
        //Lấy tổng số trang trong kết quả
        int totalPage = pageProduct.getTotalPages();
        //Lấy dữ liệu sản phẩm trên 1 trang
        List<Product> listProduct = pageProduct.getContent();
        //Chuyển từ listProduct sang listProductDTOResponse
        List<ProductDTOResponse> listProductDTOResponse = listProduct.stream()
                .map(product -> productMapper.mapperEntityToResponse(product))
                .collect(Collectors.toList());
        //Khởi tạo Map để trả về cho client
        Map<String, Object> data = new HashMap<>();
        //tổng số trang khi phân trang
        data.put("totalPage", totalPage);
        //Dữ liệu trên 1 trang
        data.put("products", listProductDTOResponse);
        return data;
    }

    @Override
    public Map<String, Object> findByNameOrPriceOrder(int page, int size, String productName, float fromPrice, float toPrice, String direction, String orderBy) {
        //Xử lý phần sắp xếp
        List<Sort.Order> listOrder = new ArrayList<>();
        Sort.Order orderName;
        Sort.Order orderPrice;
        //Xử lý sắp xếp theo tên
        if (orderBy.equals("name")){
            if (direction.equals("ASC")){
                orderName = new Sort.Order(Sort.Direction.ASC,"name");
            }else{
                orderName = new Sort.Order(Sort.Direction.DESC,"name");
            }
            listOrder.add(orderName);
        }else{
            if (direction.equals("ASC")){
                orderPrice = new Sort.Order(Sort.Direction.ASC,"price");
            }else {
                orderPrice = new Sort.Order(Sort.Direction.DESC,"price");
            }
            listOrder.add(orderPrice);
        }
        Pageable pageable = PageRequest.of(page,size,Sort.by(listOrder));
        Page<Product> pageProduct = productRepository.findByNameContainsAndPriceBetween(productName,fromPrice,toPrice,pageable);

        //Lấy tổng số trang trong kết quả
        int totalPage = pageProduct.getTotalPages();
        //Lấy dữ liệu sản phẩm trên 1 trang
        List<Product> listProduct = pageProduct.getContent();
        //Chuyển từ listProduct sang listProductDTOResponse
        List<ProductDTOResponse> listProductDTOResponse = listProduct.stream()
                .map(product -> productMapper.mapperEntityToResponse(product))
                .collect(Collectors.toList());
        //Khởi tạo Map để trả về cho client
        Map<String, Object> data = new HashMap<>();
        //tổng số trang khi phân trang
        data.put("totalPage", totalPage);
        //Dữ liệu trên 1 trang
        data.put("products", listProductDTOResponse);
        return data;
    }
}
