package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Supplier;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// @Service
public class SupplierServiceImp implements SupplierRepository{
    SupplierRepository supplierRepository;

    public Supplier SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
        return null;
    }


    @Override
    public Supplier findByCompanyNameVatNumber(String companyName, String vatNumber){
        return supplierRepository.findByCompanyNameVatNumber(companyName, vatNumber);
    }

    @Override
    public Supplier insert(Supplier p) {
        return supplierRepository.save(p);
    }

    @Override
    public void updateSupplier(String companyName, Supplier p) {
        Supplier pFromDb = supplierRepository.findByCompanyNameVatNumber(companyName, p.getVatNumber());
        System.out.println(pFromDb.toString());
        pFromDb.setId(p.getId());
        pFromDb.setFirstName(p.getFirstName());
        pFromDb.setLastName(p.getLastName());
        pFromDb.setVatNumber(p.getVatNumber());
        pFromDb.setIrsOffice(p.getIrsOffice());
        pFromDb.setAddress(p.getAddress());
        pFromDb.setZipCode(p.getZipCode());
        pFromDb.setCity(p.getCity());
        pFromDb.setCountry(p.getCountry());
        supplierRepository.save(pFromDb);
    }

    @Override
    public void deleteSupplier(String comapnyName, Supplier p) {
        supplierRepository.delete(p);
    }


    @Override
    public <S extends Supplier> S save(S entity) {
        return  null;
    }


    @Override
    public <S extends Supplier> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }


    @Override
    public Optional<Supplier> findById(Long id) {
        return null;
    }


    @Override
    public boolean existsById(Long id) {
        return false;
    }


    @Override
    public Iterable<Supplier> findAll() {
        return null;
    }


    @Override
    public Iterable<Supplier> findAllById(Iterable<Long> ids) {
        return null;
    }


    @Override
    public long count() {
        return 0;
    }


    @Override
    public void deleteById(Long id) {
        
    }


    @Override
    public void delete(Supplier entity) {
        
    }


    @Override
    public void deleteAll(Iterable<? extends Supplier> entities) {
        
    }


    @Override
    public void deleteAll() {
        
    }


    @Override
    public Page<Supplier> findByQuery(String query, Pageable pageable) {
        return null;
    }

}


