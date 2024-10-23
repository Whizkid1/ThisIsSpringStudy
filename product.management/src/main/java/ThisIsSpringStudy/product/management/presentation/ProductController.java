package ThisIsSpringStudy.product.management.presentation;

import ThisIsSpringStudy.product.management.application.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    // 아니 어떻게 getter method를 명시하지 않았는데 실행이 되지???
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return simpleProductService.add(productDto);
    }

//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public List<ProductDto> findAllProduct() {
//        return simpleProductService.findAll();
//    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts(
        @RequestParam(required = false) String name
    ) {
        if (null == name)
            return simpleProductService.findAll();
        return  simpleProductService.findByNameContaining(name);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id) {
        return simpleProductService.findById(id);
    }
}
