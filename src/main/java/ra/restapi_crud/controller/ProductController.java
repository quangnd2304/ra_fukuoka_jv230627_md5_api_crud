package ra.restapi_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ra.restapi_crud.dto.response.ProductDTOResponse;
import ra.restapi_crud.model.Product;
import ra.restapi_crud.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        return new ResponseEntity<>(productService.findAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<Map<String, Object>> findByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String productName) {
        return new ResponseEntity<>(productService.findByName(page, size, productName), HttpStatus.OK);
    }

    @GetMapping("/findByNameOrPrice")
    public ResponseEntity<Map<String, Object>> findByNameOrPrice(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String productName,
            @RequestParam(defaultValue = "0") float fromPrice,
            @RequestParam(defaultValue = "100000000") float toPrice) {
        return new ResponseEntity<>(productService.findByNameOrPrice(page, size, productName, fromPrice, toPrice), HttpStatus.OK);
    }
    @GetMapping("/findByNameOrPriceOrder")
    public ResponseEntity<Map<String,Object>> findByNameOrPriceOrder(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String productName,
            @RequestParam(defaultValue = "0") float fromPrice,
            @RequestParam(defaultValue = "100000000") float toPrice,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy){
        return new ResponseEntity<>(productService.findByNameOrPriceOrder(page, size, productName, fromPrice, toPrice, direction, orderBy),HttpStatus.OK);
    }
}
