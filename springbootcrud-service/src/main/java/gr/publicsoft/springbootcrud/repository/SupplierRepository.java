package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    Supplier findByCompanyNameVatNumber(String comapnyName, String vatNumber);


    @Query("SELECT p FROM Supplier p "
            + "WHERE p.comapnyName LIKE CONCAT('%',?1,'%') "
            + "WHERE p.vatNumber LIKE CONCAT('%',?1,'%') ")
    Page<Supplier> findByQuery(@Param("query") String query, Pageable pageable);

    Supplier insert(Supplier p);

    void updateSupplier(String comapnyName, Supplier p);

    void deleteSupplier(String comapnyName, Supplier p);


}
