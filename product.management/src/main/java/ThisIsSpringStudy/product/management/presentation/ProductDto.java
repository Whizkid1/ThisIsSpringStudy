package ThisIsSpringStudy.product.management.presentation;

import jakarta.validation.constraints.NotNull;

public class ProductDto {
    //상품 번호
    private Long id;

    //상품 이름
    @NotNull
    private String name;

    //가격
    @NotNull
    private Integer price;

    //재고 수량
    @NotNull
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
