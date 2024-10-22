package ThisIsSpringStudy.product.management.domain;

public class Product {
    //상품 번호
    private Long id;
    //상품 이름
    private String name;
    //가격
    private Integer price;
    //재고 수량
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }


}
