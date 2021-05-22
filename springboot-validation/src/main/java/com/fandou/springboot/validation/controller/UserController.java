package com.fandou.springboot.validation.controller;

import com.fandou.springboot.validation.model.User;
import com.fandou.springboot.validation.support.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * 添加用户：自行处理校验到的错误
     *
     * @param user user
     * @param bindingResult bindingResult
     * @return Result
     */
    @PostMapping("/create")
    public Result<String> create(@RequestBody @Validated User user, BindingResult bindingResult) {
        Result<String> result = new Result<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                Object rejectedValue = fieldError.getRejectedValue();
                String code = fieldError.getCode();
                String objectName = fieldError.getObjectName();
                String defaultMessage = fieldError.getDefaultMessage();
                String format = "objectName={}, field={}, rejectedValue={}, code={}, defaultMessage={}";
                LOGGER.info(format,objectName, field, rejectedValue, code, defaultMessage);
            }
            for (ObjectError error : errors) {
                String objectName = error.getObjectName();
                String code = error.getCode();
                String defaultMessage = error.getDefaultMessage();
                String format = "objectName={}, code={}, defaultMessage={}";
                LOGGER.info(format,objectName, code, defaultMessage);
            }
            result.setCode("101");
            result.setData("ERROR");
            return result;
        }
        result.setCode("200");
        result.setData("OK");
        LOGGER.info(user.toString());
        return result;
    }

    /**
     * 更新用户：校验到错误将抛出异常，在全局异常处理器类中处理错误
     *
     * @param user user
     * @return Result
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody @Validated User user) {
        LOGGER.info(user.toString());
        Result<String> result = new Result<>();
        result.setCode("200");
        result.setData("OK");
        return result;
    }

    /**
     * 删除用户：检查抛出Throwable能否在全局异常处理类中处理，结论是可以
     *
     * @param user user
     * @return Result
     * @throws Throwable Throwable
     */
    @PostMapping("/delete")
    public Result<String> delete(@RequestBody @Validated User user) throws Throwable {
        LOGGER.info(user.toString());
        Result<String> result = new Result<>();
        result.setCode("200");
        result.setData("OK");
        String id = user.getId();
        if (Objects.isNull(id)) {
            throw new Throwable("id不能为空");
        }
        return result;
    }

    /**
     * 校验非实体类的单个或多个RequestParam参数：需要在controller类上加@Validated注解才会生效
     *
     * @param name name
     * @return Result
     */
    @GetMapping("/query")
    public Result<String> query(@RequestParam(value = "name") @NotBlank(message = "name长度应大于0") String name) {
        LOGGER.info("name:{}", name);
        Result<String> result = new Result<>();
        result.setCode("200");
        result.setData("OK");
        return result;
    }

    /**
     * 校验非实体类的PathVariable参数：需要在controller类上加@Validated注解才会生效
     *
     * @param id id
     * @return Result
     */
    @GetMapping("/get/{id}")
    public Result<String> get(@PathVariable(value = "id",required = false) @Size(min = 4, max = 128, message = "id长度4-128") String id) {
        LOGGER.info("id:{}", id);
        Result<String> result = new Result<>();
        result.setCode("200");
        result.setData("OK");
        return result;
    }

    /**
     * (只)在controller类上加@Validated注解是否会对没有加校验注解的方法参数自动进行校验：结论是不会
     *
     * @param id id
     * @return Result
     */
    @GetMapping("/export")
    public Result<String> export(@RequestParam(value = "id", required = false) String id) {
        LOGGER.info("id:{}", id);
        Result<String> result = new Result<>();
        result.setCode("200");
        result.setData("OK");
        return result;
    }
}
