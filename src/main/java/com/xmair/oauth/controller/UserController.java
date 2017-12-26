package com.xmair.oauth.controller;

import com.xmair.oauth.configuration.ConfigBean;
import com.xmair.oauth.entity.User;
import com.xmair.oauth.mapper.UserMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Song on 2017/2/15.
 * User控制层
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
   // @Autowired
   // private UserService userService;

    @Autowired
    private ConfigBean configBean;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }


/*
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){

        List<String> list = Arrays.asList("Hello", "World!","ss");
        
        list.stream().forEach(System.out::println);

        User user = userService.findUserByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassowrd()+"/"+user.getPassword()+"122222";

        else return "null";
    }*/

    @RequestMapping(value = "/mybatistest",method = RequestMethod.GET)
    @ResponseBody
    public  String mybatistest(){


        User user=  userMapper.findByName("111");
        if(null != user)
            return configBean.getName()+"//"+ user.getId()+"/"+user.getName()+"/"+user.getPassowrd()+"/"+user.getPassword()+"122222";

        else return "null";


    }

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
