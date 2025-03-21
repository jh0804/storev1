package com.metacoding.storev1.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.metacoding.storev1.log.LogResponse.ListPage;

@Import(LogRepository.class)
@DataJpaTest // em IoC 등록
public class LogRepositoryTest {
    
    @Autowired // DI하는 annotation. 새로운 DI 방법 (annotation으로 주입. 디폴트 생성자로 new되는데 ...)
    private LogRepository logRepository; // 이것만 있으면 아직 null임

    @Test // 세모 버튼 생김
    public void findAllJoinStore_test(){ // _test = 컨벤션  // 매개변수에 아무것도 적을 수 없다.
        List<LogResponse.ListPage> logList = logRepository.findAllJoinStore();
        for (ListPage listPage : logList){
            System.out.println(listPage);
        }
    }
}
