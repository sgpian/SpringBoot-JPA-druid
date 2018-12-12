package com.example.controller;

import com.example.dao.UserRepository;
import com.example.entity.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */
@RestController
@RequestMapping("/users")
public class WebController {
    @Resource
    private UserRepository userRepository;

    //其中@ApiOperation和@ApiParam为添加的API相关注解，各参数说明如下：

    //@ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response = “接口返回参数类型”, notes = “接口发布说明”；其他参数可参考源码；

    //@ApiParam(required = “是否必须参数”, name = “参数名称”, value = “参数具体描述”

    //

    @ApiOperation(value = "获取客户列表", notes = "0101")
    @GetMapping("/getUserList")
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(userRepository.findAll());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
//    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userRepository.save(user);
        return "success " + user.toString();
    }


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id) {
        return userRepository.findOne(Integer.valueOf(id));
    }


    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable String id, @RequestBody User user) {
        User u = userRepository.findOne(Integer.valueOf(id));
        u.setName(user.getName());
        u.setAge(user.getAge());
        userRepository.saveAndFlush(u);
        return "success  " + u.toString();
    }


    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        userRepository.delete(Integer.valueOf(id));
        return "success";
    }


}
