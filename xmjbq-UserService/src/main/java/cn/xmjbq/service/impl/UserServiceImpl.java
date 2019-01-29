package cn.xmjbq.service.impl;

import cn.xmjbq.common.ResponseJson;
import cn.xmjbq.pojo.User;
import cn.xmjbq.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author howinfun
 * @version 1.0
 * @desc
 * @date 2019/1/23
 * @company XMJBQ
 */

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public ResponseJson sayHello(User user) {
        ResponseJson responseJson = new ResponseJson();
        try{
            responseJson.setData(user);
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
