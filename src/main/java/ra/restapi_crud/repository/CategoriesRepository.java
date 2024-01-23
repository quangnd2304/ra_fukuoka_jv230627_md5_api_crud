package ra.restapi_crud.repository;


import org.hibernate.query.spi.Limit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.restapi_crud.model.Categories;

import java.util.Date;
import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

}
