package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {
    
    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }


    @Transactional // import 주의 jakarta 아님!
    public void 상품등록(String name, int stock, int price){
        storeRepository.save(name, stock, price);
    }

    // model = List<Store> (움직이는 데이터)
    public List<Store> 상품목록(){
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }


    public Store 상품상세보기(int id) {
        Store store = storeRepository.findById(id);
        return store;
    }

    // 3번 : board 프로젝트의 BoardService 참고
    @Transactional // insert, delete, update시에 사용 : 함수 종료시 commit됨
    public void 상품삭제(int id) {
        // 1. 상품 있는지 확인하고 
        Store store = storeRepository.findById(id);
        // 2. 삭제하기
        if (store == null) {
            throw new RuntimeException("상품이 없는데 왜 삭제를 ㅠㅠ");
        }
        storeRepository.deleteById(id); 
    }

    @Transactional
    public void 상품수정(int id, String name, int stock, int price) {
        // 1. 상품 있는지 확인하고
        Store store = storeRepository.findById(id);
        // 2. 없으면 터트리고
        if (store == null){
            throw new RuntimeException("상품이 없는데 왜 수정을 ㅠㅠ");
        }
        // 3. 수정하기
        storeRepository.updateById(id, name, stock, price);
    }
}
