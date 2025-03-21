package com.metacoding.storev1.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // JPA가 ObjectMapping을 위해 new할 때 사용한다.
@Table(name = "store_tb")
@Entity // 설정파일에서 테이블을 생성해준다. (JPA)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer stock; // 재고
    private Integer price;

    public void 재고감소(int qty) {
        this.stock = this.stock - qty;
    }
}
