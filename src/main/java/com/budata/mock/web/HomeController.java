package com.budata.mock.web;

import com.budata.mock.annotation.Jwt;
import com.budata.mock.model.Foo;
import com.budata.mock.model.JwtAccount;
import com.budata.mock.util.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @GetMapping("/drink")
    public R drink(@Valid Foo foo, BindingResult bindingResult) {
        return R.succ("drink");
    }

    @GetMapping("/drink2")
    public R drink2(@Validated({Foo.Adult.class}) Foo foo, BindingResult bindingResult) {
        return R.succ("drink2");
    }
}
