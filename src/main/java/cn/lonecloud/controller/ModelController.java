package cn.lonecloud.controller;

import cn.lonecloud.pojo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonecloud
 * @version v1.0
 * @date 上午9:23 2018/1/6
 */
@RequestMapping("model")
@RestController
public class ModelController {

    @PostMapping("/save")
    public User save(@ModelAttribute("user") User user,User user2){
        return user;
    }
}
