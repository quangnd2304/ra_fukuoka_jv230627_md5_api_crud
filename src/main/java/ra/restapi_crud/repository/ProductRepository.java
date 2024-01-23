package ra.restapi_crud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.restapi_crud.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Page<Product> findByNameContains(String productName, Pageable pageable);
    Page<Product> findByNameContainsAndPriceBetween(String productName,float fromPrice, float toPrice, Pageable pageable);
  }
