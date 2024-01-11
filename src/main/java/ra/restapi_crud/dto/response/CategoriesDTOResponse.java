package ra.restapi_crud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CategoriesDTOResponse {
    private int id;
    private String name;
    private int priority;
    private String descriptions;
    private boolean status;
}
