package ra.restapi_crud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductDTOResponse {
    private String id;
    private String name;
    private float price;
    private boolean status;
    private int catalogId;
    private String catalogName;
}
