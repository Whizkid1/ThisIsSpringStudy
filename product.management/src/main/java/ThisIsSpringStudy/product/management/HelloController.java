package ThisIsSpringStudy.product.management;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Welcome to <strong>DongWon Spring study World</strong>";
    }

    // pracHtml2.html과 연동
    @RequestMapping("/article")
    public String createArticle(@RequestParam("title") String title,
                                @RequestParam("content") String content) {
        return String.format("title=%s / content=%s", title, content);
    }

    @RequestMapping("/get-with-no-parameter")
    public String getWithNoParameter() {
        return "파라미터가 없는 GET 요청";
    }
}
