package ra.restapi_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.restapi_crud.model.Categories;
@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
}
