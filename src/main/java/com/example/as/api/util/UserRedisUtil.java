package com.example.as.api.util;

import com.example.as.api.entity.UserEntity;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserRedisUtil {

    public static final String BOARDING_PASS = "boarding-pass";

    /**
     * 将用户信息保存到 Redis
     *
     * @param redisTemplate
     * @param session
     * @param userEntity
     */
    public static void addUser(StringRedisTemplate redisTemplate, HttpSession session, UserEntity userEntity) {
        //用户session写入redis
        redisTemplate.opsForValue().set(getKey(session), JsonUtil.toJsonString(userEntity));
    }

    /**
     * 将用户信息从 Redis中移除
     *
     * @param redisTemplate
     * @param session
     */
    public static void removeUser(StringRedisTemplate redisTemplate, HttpSession session) {
        //移除session
        session.invalidate();
        //将用户从redis中移除
        redisTemplate.delete(getKey(session));
    }

    /**
     * 检查Redis中是否存在该用户
     *
     * @param redisTemplate
     * @param request
     * @return
     */
    public static boolean checkUser(StringRedisTemplate redisTemplate, HttpServletRequest request) {
        String val = redisTemplate.opsForValue().get(getBoardingPass(request));
        return val != null;
    }

    /**
     * 根据session id 获取 缓存在redis中的用户信息
     *
     * @param redisTemplate
     * @param request
     * @return
     */
    public static UserEntity getUser(StringRedisTemplate redisTemplate, HttpServletRequest request) {
        //检测redis中是否含有session id
        String val = redisTemplate.opsForValue().get(getBoardingPass(request)); //获取登录令牌
        if (val != null) {
            return JsonUtil.fromJson(val, UserEntity.class);
        }
        return null;
    }

    /**
     * 获取redis存储的key
     *
     * @param session
     * @return
     */
    public static String getKey(HttpSession session) {
        return session.getId();
    }

    /**
     * 获取用户是否登录的凭证
     *
     * @param request
     * @return
     */
    public static String getBoardingPass(HttpServletRequest request) {
        String pass = request.getHeader(BOARDING_PASS);
        return pass != null ? pass : "no-pass";
    }
}
