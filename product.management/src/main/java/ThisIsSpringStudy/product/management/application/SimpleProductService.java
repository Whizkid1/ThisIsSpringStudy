package ThisIsSpringStudy.product.management.application;

import ThisIsSpringStudy.product.management.domain.Product;
import ThisIsSpringStudy.product.management.infrastructure.ListProductRepository;
import ThisIsSpringStudy.product.management.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        // 1. ProductDto를 Product로 변환하는 코드
        Product product = modelMapper.map(productDto, Product.class);

        // 2. 레포지토리를 호출하는 코드
        Product savedProduct = listProductRepository.add(product);

        // 3. Product를 ProductDto로 새로 변환하는 코드
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        // 4. DTO를 반환하는 코드
        return  savedProductDto;
    }

    public ProductDto findById(Long id) {
        Product product = listProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<Product> products = listProductRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = listProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
        return productDtos;
    }
}
