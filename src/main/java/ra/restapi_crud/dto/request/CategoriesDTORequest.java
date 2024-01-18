package ra.restapi_crud.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Data
public class CategoriesDTORequest {
    private int id;
    @NotNull(message = "Tên danh mục không được null")
    @Length(min = 10, max = 30, message = "Độ dài tên danh mục từ 10-30 ký tự")
    private String name;
    @Min(value = 1, message = "Giá trị priority nhỏ nhất là 1")
    @Max(value = 10,message = "Giá trị priority lớn nhất là 10")
    private int priority;
    @NotBlank(message = "Mô tả không được để trống")
    private String descriptions;
    private boolean status;
    @Digits(integer = 3,fraction = 2,message = "Không đúng định dạng số thực")
    private float price;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Không đúng định dạng email")
    private String email;
    @Size(min = 3,max = 5, message = "Mảng phải gồm từ 3 đến 5 phần tử")
    private int[] arrInt;
}
