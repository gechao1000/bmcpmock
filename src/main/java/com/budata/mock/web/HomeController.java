package com.budata.mock.web;

import com.budata.mock.annotation.Jwt;
import com.budata.mock.model.JwtAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController class
 *
 * @author gexc
 * @date 2019/05/27
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "@index";
    }

    @GetMapping("/jwt")
    public JwtAccount jwt(@Jwt JwtAccount jwt) {
        return jwt;
    }

    @GetMapping("/jwt2")
    public JwtAccount jwt2(@Jwt("auth") JwtAccount jwt) {
        return jwt;
    }
}
