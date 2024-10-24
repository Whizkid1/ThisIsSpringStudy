package ThisIsSpringStudy.product.management.domain;

import java.util.Objects;

public class Product {
    //상품 번호
    private Long id;
    //상품 이름
    private String name;
    //가격
    private Integer price;
    //재고 수량
    private Integer amount;

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    public Boolean containsName(String name) {
        return this.name.contains(name);
    }

    // ListProductRepository의 update 함수에서 사용하는 indexOf 를 위한 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }
}
