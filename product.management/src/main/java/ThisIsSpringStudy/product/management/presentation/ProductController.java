package ThisIsSpringStudy.product.management.presentation;

import ThisIsSpringStudy.product.management.application.SimpleProductService;
import ThisIsSpringStudy.product.management.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    // 아니 어떻게 getter method를 명시하지 않았는데 실행이 되지???
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return simpleProductService.add(product);
    }
}
