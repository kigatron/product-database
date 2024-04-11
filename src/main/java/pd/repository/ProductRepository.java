package pd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pd.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.name = :pname")
    public List<Product> findProductByName(@Param("pname") String pname);

    @Query("select p from Product p where p.price = :price")
    public List<Product> findProductByPrice(@Param("price") float price);

    @Query("select p.name, p.price, o.oid, o.ldt from Product p, Orders o where p.pid = o.pid")
    public List<Object[]> orderDetails();
}
