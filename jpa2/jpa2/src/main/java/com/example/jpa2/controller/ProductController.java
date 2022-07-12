package com.example.jpa2.controller;


import com.example.jpa2.dto.ProductDto;
import com.example.jpa2.dto.ProductResponseDto;
import com.example.jpa2.dto.UpdateProductNameDto;
import com.example.jpa2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long id){
        ProductResponseDto productResponseDto = productService.getProduct(id);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto){
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> updateProduct(
            @RequestBody UpdateProductNameDto updateProductNameDto) throws Exception{
        ProductResponseDto productResponseDto = productService.updateProduct(
                updateProductNameDto.getId(), updateProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(Long id) throws Exception{
        productService.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}