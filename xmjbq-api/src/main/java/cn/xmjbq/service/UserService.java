package cn.xmjbq.service;

import cn.xmjbq.common.ResponseJson;
import cn.xmjbq.pojo.User;

/**
 * @author howinfun
 * @version 1.0
 * @desc 下载应用Service
 * @date 2018/12/11
 * @company XMJBQ
 */
public interface UserService {

    public ResponseJson sayHello(User user);
}
