package ra.restapi_crud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoriesDTORequest {
    private int id;
    private String name;
    private int priority;
    private String descriptions;
    private boolean status;
}
