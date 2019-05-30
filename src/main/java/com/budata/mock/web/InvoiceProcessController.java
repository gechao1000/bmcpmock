package com.budata.mock.web;

import com.budata.mock.model.BaseParam;
import com.budata.mock.util.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 发票处理
 *
 * @author gexc
 * @date 2019/05/24
 */
@RestController
@RequestMapping("invoice")
public class InvoiceProcessController {

    /**
     * 扫描仪
     *
     */
    @PostMapping("scanner")
    public R scanner(@Valid @RequestBody BaseParam param, BindingResult result) {
        return R.succ("扫描仪接口调用成功");
    }

    /**
     * 国税
     *
     */
    @PostMapping("nationalTax")
    public R nationalTax(@Valid @RequestBody BaseParam param, BindingResult result) {
        return R.succ("国税接口调用成功");
    }

    /**
     * 银行
     *
     */
    @PostMapping("bank")
    public R bank(@Valid @RequestBody BaseParam param, BindingResult result) {
        return R.succ("银行接口调用成功");
    }


    /**
     * 百旺
     *
     */
    @PostMapping("baiwang")
    public R baiwang(@Valid @RequestBody BaseParam param, BindingResult result) {
        return R.succ("百旺接口调用成功");
    }

    /**
     * 长益
     *
     */
    @PostMapping("changyi")
    public R changyi(@Valid @RequestBody BaseParam param, BindingResult result) {
        return R.succ("长益接口调用成功");
    }

    /**
     * 电子签章
     *
     */
    @PostMapping("sign")
    public R sign(@Valid @RequestBody BaseParam param, BindingResult result) {
        return R.succ("电子签章接口调用成功");
    }

}
