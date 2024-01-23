package ra.restapi_crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "product_id",columnDefinition = "char(5)")
    private String id;
    @Column(name = "product_name",columnDefinition = "varchar(100)",nullable = false, unique = true)
    private String name;
    private float price;
    @Column(name = "product_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private Categories catalog;
}
