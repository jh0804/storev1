package com.metacoding.storev1.log;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LogController {
    
    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public String list(HttpServletRequest request) {
        List<LogResponse.ListPage> listPage = logService.구매목록();  // dto를 받음 (model은 테이블과 똑같은 것)
        request.setAttribute("models", listPage);
        return "log/list";
    }

    @PostMapping("/log/save")
    public String save(@RequestParam("storeId") int storeId, @RequestParam("buyer") String buyer, @RequestParam("qty") int qty){
        logService.구매하기(storeId, buyer, qty);
        return "redirect:/log";
    }
}
