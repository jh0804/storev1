package com.metacoding.storev1.log;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO : Data Transfer Object -> 화면에 필요한 데이터만 있는 오브젝트
public class LogResponse { // log list에서 응답되는 데이터만 담은 거

    // LogResponse.DTO로 접근 -> 관리 용이
    // 예) LogResponse.DTO dto = new LogResponse.DTO();
    @AllArgsConstructor
    @Data // 내부에 getter,setter,toString을 담고 있음
    public static class ListPage{
        // new 3번해서 collection에 담는다?
        private int id;
        private String name;
        private int qty;
        private int totalPrice;
        private String buyer;
        
        // public ListPage(int id, String name, int qty, int totalPrice, String buyer) {
        //     this.id = id;
        //     this.name = name;
        //     this.qty = qty;
        //     this.totalPrice = totalPrice;
        //     this.buyer = buyer;
        // }   

        // //toString()
        // @Override
        // public String toString() {
        //     return "ListPage [id=" + id + ", name=" + name + ", qty=" + qty + ", totalPrice=" + totalPrice + ", buyer=" + buyer + "]";
        // }
    }
}
