package cn.xmjbq.controller;

import cn.xmjbq.common.ResponseJson;
import cn.xmjbq.pojo.User;
import cn.xmjbq.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author howinfun
 * @version 1.0
 * @desc
 * @date 2019/1/23
 * @company XMJBQ
 */
@RequestMapping("user")
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Reference(interfaceClass = UserService.class)
    private UserService userService;

    @RequestMapping("sayHello")
    public ResponseJson sayHello(@RequestBody User user) {
        ResponseJson responseJson = new ResponseJson();
        try{
            responseJson =  userService.sayHello(user);
        }catch (Exception e){
            logger.error("服务器报错：",e);
            responseJson.setSuccess(false);
            responseJson.setCode(500);
            responseJson.setMsg("服务器报错");
            return responseJson;
        }
        return responseJson;
    }
}
