package ThisIsSpringStudy.product.management;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    // 아니 어떻게 getter method를 명시하지 않았는데 실행이 되지???
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return product;
    }
}
