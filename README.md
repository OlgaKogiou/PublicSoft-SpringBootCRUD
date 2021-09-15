# PublicSoft-SpringBootCRUD
Supplier Entity

In the root package of our project a package with the name controllers has been created. In the controllers package we created, a Java class with the name SupplierController has been added.

@RestController annotation marks this class as a controller that can process the incoming HTTP requests.

@RequestMapping("/api/v1/supplier") annotation sets the base path to the resource endpoints in the controller as /api/v1/supplier.

We inject the SupplierService through our contractor to be able to use the various methods defined in it within the SupplierController class.

@GetMapping annotation indicates that the function processes a GET request.

@PostMapping annotation indicates that a function processes a POST request.

@PutMapping annotation indicates that a function processes a PUT request.

@DeleteMapping annotation indicates that a function processes a DELETE request
