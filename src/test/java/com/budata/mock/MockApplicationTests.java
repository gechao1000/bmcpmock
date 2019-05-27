package com.budata.mock;

import com.budata.mock.model.BaseParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockApplicationTests {

    @Test
    public void contextLoads() {
        BaseParam param = new BaseParam();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<BaseParam>> validate = validator.validate(param);
    }

}
