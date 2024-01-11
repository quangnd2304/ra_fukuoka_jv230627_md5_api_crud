package ra.restapi_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.restapi_crud.dto.request.CategoriesDTORequest;
import ra.restapi_crud.dto.response.CategoriesDTOResponse;
import ra.restapi_crud.dto.response.Message;
import ra.restapi_crud.service.CategoriesService;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    //GET
    //request: data ở header của request
    //response: data trả về nằm ở body của response
    @GetMapping
    public ResponseEntity<List<CategoriesDTOResponse>> findAll() {
        List<CategoriesDTOResponse> listCategories = categoriesService.findAll();
        return new ResponseEntity<>(listCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        CategoriesDTOResponse categories = categoriesService.findById(id);
        if (categories == null) {
            //id không đúng --> trả về đối tượng message
            return new ResponseEntity<>(new Message("Id not found"), HttpStatus.NOT_FOUND);
        } else {
            //id đúng --> trả về đối tượng CategoriesDTOResponse
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriesDTOResponse> save(@RequestBody CategoriesDTORequest categoriesDTORequest) {
        CategoriesDTOResponse categories = categoriesService.save(categoriesDTORequest);
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CategoriesDTORequest categoriesDTORequest, @PathVariable int id) {
        CategoriesDTOResponse categories = categoriesService.update(categoriesDTORequest, id);
        if (categories == null) {
            //id không tồn tại --> không cập nhật
            return new ResponseEntity<>(new Message("Id not found"), HttpStatus.NOT_FOUND);
        } else {
            //id tồn tại --> cập nhật
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> delete(@PathVariable int id) {
        boolean result = categoriesService.delete(id);
        if (result) {
            return new ResponseEntity<>(new Message("Delete succesful"), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(new Message("Id not found"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<CategoriesDTOResponse>> find(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String orderBy
    ) {
        List<CategoriesDTOResponse> listCategories = categoriesService.find(direction, orderBy, page, size);
        return new ResponseEntity<>(listCategories, HttpStatus.OK);
    }
}
