package ThisIsSpringStudy.product.management.application;

import ThisIsSpringStudy.product.management.domain.Product;
import ThisIsSpringStudy.product.management.domain.ProductRepository;
import ThisIsSpringStudy.product.management.infrastructure.DatabaseProductRepository;
import ThisIsSpringStudy.product.management.infrastructure.ListProductRepository;
import ThisIsSpringStudy.product.management.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class SimpleProductService {

    private ProductRepository productRepository;
//    private ListProductRepository listProductRepository;
//    private DatabaseProductRepository databaseProductRepository;
//    private ModelMapper modelMapper;
    private ValidationService validationService;

    @Autowired
    SimpleProductService(
            //ListProductRepository listProductRepository,
            //DatabaseProductRepository databaseProductRepository,
            ProductRepository productRepository,
            //ModelMapper modelMapper,
            ValidationService validationService
    ) {
        //this.listProductRepository = listProductRepository;
        //this.databaseProductRepository = databaseProductRepository;
        this.productRepository = productRepository;
        //this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto) {
        // 1. ProductDto를 Product로 변환하는 코드
        //Product product = modelMapper.map(productDto, Product.class);
        Product product = ProductDto.toEntity(productDto);
        // 1-2. 유효성 검사
        validationService.checkValid(product);

        // 2. 레포지토리를 호출하는 코드
        //Product savedProduct = listProductRepository.add(product);
        //Product savedProduct = databaseProductRepository.add(product);
        Product savedProduct = productRepository.add(product);

        // 3. Product를 ProductDto로 새로 변환하는 코드
        //ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);
        ProductDto savedProductDto = ProductDto.toDto(savedProduct);

        // 4. DTO를 반환하는 코드
        return  savedProductDto;
    }

    public ProductDto findById(Long id) {
        //Product product = listProductRepository.findById(id);
        //Product product = databaseProductRepository.findById(id);
        Product product = productRepository.findById(id);
        //ProductDto productDto = modelMapper.map(product, ProductDto.class);
        ProductDto productDto = ProductDto.toDto(product);
        return productDto;
    }

    public List<ProductDto> findAll() {
        //List<Product> products = listProductRepository.findAll();
        //List<Product> products = databaseProductRepository.findAll();
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                //.map(product -> modelMapper.map(product, ProductDto.class))
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        //List<Product> products = listProductRepository.findByNameContaining(name);
        //List<Product> products = databaseProductRepository.findByNameContaining(name);
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                //.map(product -> modelMapper.map(product, ProductDto.class))
                .map(product -> ProductDto.toDto(product))
                .toList();
        return productDtos;
    }

    public ProductDto update(ProductDto productDto) {
        //Product product = modelMapper.map(productDto, Product.class);
        Product product = ProductDto.toEntity(productDto);
        //Product updatedProduct = listProductRepository.update(product);
        //Product updatedProduct = databaseProductRepository.update(product);
        Product updatedProduct = productRepository.update(product);
        ProductDto updatedProductDto = ProductDto.toDto(updatedProduct);
        return updatedProductDto;
    }

    public void delete(Long id) {
        //listProductRepository.delete(id);
        //databaseProductRepository.delete(id);
        productRepository.delete(id);
    }
}
