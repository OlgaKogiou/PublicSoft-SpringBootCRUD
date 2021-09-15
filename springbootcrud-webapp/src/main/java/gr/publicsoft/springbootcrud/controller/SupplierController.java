package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {
    SupplierRepository supplierService;

    public SupplierController(SupplierRepository supplierService) {
        this.supplierService = supplierService;
    }


    //The function receives a GET request, processes it, and gives back a list of Todo as a response.
    @GetMapping({"/{companyName}, /{vatNumber}"})
    public ResponseEntity<Supplier> getSupplier(@PathVariable String companyName, @PathVariable String vatNumber) {
        return new ResponseEntity<>(supplierService.findByCompanyNameVatNumber(companyName, vatNumber), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Supplier and saves it to the database, and returns a resource link to the created todo.    
    @PostMapping
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
        supplierService.insert(supplier);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("supplier", "/api/v1/supplier/" + supplier.getId());
        return new ResponseEntity<>(supplier, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Supplier with the specified Id and returns the updated Supplier
    @GetMapping({"/{companyName}, /{vatNumber}"})
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("companyName") String companyName, @RequestBody Supplier supplier) {
        supplierService.updateSupplier(companyName, supplier);
        return new ResponseEntity<>(supplierService.findByCompanyNameVatNumber(companyName, supplier.getVatNumber()), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{companyName}, /{vatNumber}"})
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("companyName") String companyName, @RequestBody Supplier supplier) {
        supplierService.updateSupplier(companyName, supplier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
