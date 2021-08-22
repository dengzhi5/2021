package com.dz.controller;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EhcacheUtils implements ApplicationRunner {
    private static Cache cache;
    private static String PRE;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        EhCacheCacheManager ehCacheCacheManager = SpringContextUtil.getBean(EhCacheCacheManager.class);
        CacheManager cacheManager = ehCacheCacheManager.getCacheManager();
        cache = cacheManager.getCache("order");

        PRE = SpringContextUtil.getProperty("spring.application.name") + ":";
    }


    /**
     * @return
     * @author chenping01
     * @Param dueTime 过期时间(秒)
     * @Date 2018/12/29
     * @Description 过期时间
     */
    public static void put(String key, Object value, int dueTime) {
        if (dueTime < 0) {
            throw new ServerInternalException(YxErrorMsgEnum.INNER_ERROR.getCode(), "过期时间不能为负数");
        }

        Element element = new Element(PRE + key, value, dueTime, dueTime);
        cache.put(element);
    }

    /**
     * @return Object key 对于的值
     * @author chenping01
     * @Param
     * @Date 2018/12/29
     * @Description
     */
    public static Object get(String key) throws NullPointerException {
        Element element = cache.get(PRE + key);
        if (element == null) {
            return null;
        } else {
            return element.getObjectValue();
        }

    }
    /**
     * @return Object key 对于的值
     * @author chenping01
     * @Param
     * @Date 2018/12/29
     * @Description
     */
    public static Element getElement(String key) throws NullPointerException {
        return cache.get(PRE + key);
    }

    /**
     * @author chenping01
     * @param[key]
     * @return boolean
     * @date 2019/7/19
     * @description 移除
     */
    public static boolean remove(String key){
        return cache.remove(PRE + key);
    }

}