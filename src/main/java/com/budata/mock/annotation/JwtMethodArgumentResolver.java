package com.budata.mock.annotation;

import com.budata.mock.model.JwtAccount;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * JwtMethodArgumentResolver class
 *
 * @author gexc
 * @date 2019/05/27
 */
public class JwtMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.hasParameterAnnotation(Jwt.class)) && parameter.getParameterType().equals(JwtAccount.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Jwt annotation = parameter.getParameterAnnotation(Jwt.class);
        String header = webRequest.getHeader(annotation.value());
        JwtAccount jwt = new JwtAccount();
        jwt.setName(annotation.value());
        jwt.setCode(header);
        return jwt;
    }
}
