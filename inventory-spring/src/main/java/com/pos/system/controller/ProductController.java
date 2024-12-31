package com.pos.system.controller;
import com.pos.system.dto.ProductDto;
import com.pos.system.service.ProductService;
import com.pos.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createProduct(@RequestBody ProductDto productDto) throws SQLException, ClassNotFoundException {
        productService.saveProduct(productDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Product was saved!", productDto),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path = "/list")
    public ResponseEntity<StandardResponse> findAllProduct() throws SQLException, ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "Data List!", productService.findAllProducts()),
                HttpStatus.OK
        );
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<StandardResponse> updateProduct(@RequestBody ProductDto dto, @PathVariable String id) throws SQLException, ClassNotFoundException {
        productService.updateProduct(dto, id);
        return new ResponseEntity<>(
                new StandardResponse( 201,"Product was updated!",dto.getCode()),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteProduct(@PathVariable long id) throws SQLException, ClassNotFoundException {
        productService.deleteProduct(id);
        return new ResponseEntity<>(
                new StandardResponse( 204 ," was Deleted!",id),
                HttpStatus.NO_CONTENT
        );
    }
}
