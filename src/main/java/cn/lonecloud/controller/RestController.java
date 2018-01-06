package cn.lonecloud.controller;

import cn.lonecloud.pojo.Admin;
import cn.lonecloud.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lonecloud
 * @version v1.0
 * @date 下午7:56 2017/11/5
 */
@Controller
@RequestMapping("/")
public class RestController {

    /**
     * http://localhost:8080/SpringMvc/simple?id=1&name=12
     * User{id='1', name='12', age=0}
     * @param user
     * @return
     */
    @RequestMapping("/simple")
    public @ResponseBody String simpleObject(User user){
        return user.toString();
    }

    /**
     * http://localhost:8080/SpringMvc/simple?id=1&name=12&group.id=23&group.name=12
     * User{id='1', name='12', age=0, group=Group{id='23', name='12'}}
     * @param user
     * @return
     */
    @RequestMapping("/deep")
    public @ResponseBody String deepObject(User user){
        return user.toString();
    }

    /**
     * http://localhost:8080/SpringMvc/doubleObject?id=1&name=12&group.id=23&group.name=12
     * User{id='1', name='12', age=0, group=Group{id='23', name='12'}}Admin{id='1', name='12', age=0, group=Group{id='23', name='12'}}
     * http://localhost:8080/SpringMvc/doubleObject?user.id=1&user.name=12&group.id=23&group.name=12
     * User{id='null', name='null', age=0, group=Group{id='23', name='12'}}Admin{id='null', name='null', age=0, group=Group{id='23', name='12'}}
     * @param user
     * @param admin
     * @return
     */
    @RequestMapping("/doubleObject")
    public @ResponseBody String doubleObject(User user, Admin admin){
        return user.toString()+admin.toString();
    }

    /**
     * 添加如下后
     * User{id='1', name='12', age=0, group=Group{id='23', name='12'}}Admin{id='null', name='null', age=0, group=Group{id='23', name='12'}}
     * @param webDataBinder
     */
    //需要让其生效则使用
    @InitBinder("user")
    public void initUser(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("admin")
    public void initAdmin(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("admin.");
    }
}
