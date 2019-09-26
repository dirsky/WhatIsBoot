package com.frank.boot.controller;

import com.frank.boot.entities.User;
import com.frank.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 16:48 2019/9/25
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private String prefix = "system/user";

    @Autowired
    private UserService userService;

    /**
     * 添加数据
     * valid 开启对user的数据校验
     * 实际是ModelAtrribute返回到前端返回错误
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String add(@Valid User user, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            System.out.println("校验有问题3");
            return prefix + "/user_add";
        } else {
            userService.add(user);
        }
        return "redirect:/user";
    }

    @RequestMapping("")
    public String index(User user, Model model) {
        System.out.println("this is index2");
        model.addAttribute("list", userService.showAll());
        return prefix + "/user_add";
    }

    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return prefix + "/user_edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String edit(User user) {
        userService.edit(user);
        return "ok";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.deleteById(id);
        return "redirect:/user";
    }
}
