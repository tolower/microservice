package com.xmair.core.configuration;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
@ConfigurationProperties(prefix = "spring.redisson")
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport
{
    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 生产key的策略,注意：如果方法参数是引用类型，必须自己实现tostring方法，来区分不同的类实例
     *
     * @return
     */

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());

                }
                int i=1;

                return sb.toString();
            }
        };

    }

    /**
     * 管理缓存
     *
     * @param redisTemplate
     * @return
     */

    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager CacheManager(RedissonClient redissonClient) {
        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
        //RLock
        config.put("testMap", new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000));

        RedissonSpringCacheManager cacheManager= new RedissonSpringCacheManager(redissonClient, config);
        return  cacheManager;
    }


    @Bean
    public RedissonClient initRedissonClient () {
        Config config = new Config();
        config.setLockWatchdogTimeout(20000);

        ClusterServersConfig serversConfig=config.useClusterServers();
        if(!(getPassword()==null || getPassword().equals(""))) {
            serversConfig.setPassword(password);
        }
        serversConfig.setReadMode(ReadMode.MASTER_SLAVE);
        
        serversConfig.setMasterConnectionMinimumIdleSize(masterConnectionMinimumIdleSize);
        serversConfig.setSlaveConnectionMinimumIdleSize(slaveConnectionMinimumIdleSize);
        serversConfig.setSubscriptionConnectionMinimumIdleSize(5);
        serversConfig.setScanInterval(3000);
        serversConfig.setSlaveConnectionPoolSize(maxConnectionSize);
        serversConfig.setMasterConnectionPoolSize(maxConnectionSize);

        // 使用 lambda 表达式以及函数操作(functional operation)
        nodeAddresses.forEach((node) -> serversConfig.addNodeAddress(node));
        try {
            RedissonClient redisson = Redisson.create(config);
            return  redisson;
        }catch (RedisConnectionException e)
        {
            logger.error("redis初始化异常",e);
            return  null;
        }

    }

    private  String readMode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private  String password;

    private  String retryAttempts;

    private  String idleConnectionTimeout;

    public int getMaxConnectionSize() {
        return maxConnectionSize;
    }

    public void setMaxConnectionSize(int maxConnectionSize) {
        this.maxConnectionSize = maxConnectionSize;
    }

    private  int maxConnectionSize;


    private  int masterConnectionMinimumIdleSize;

    private  int slaveConnectionMinimumIdleSize;

    public int getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    public void setMasterConnectionMinimumIdleSize(int masterConnectionMinimumIdleSize) {
        this.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
    }

    public int getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    public void setSlaveConnectionMinimumIdleSize(int slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }

    private List<String> nodeAddresses;

    public String getReadMode() {
        return readMode;
    }

    public void setReadMode(String readMode) {
        this.readMode = readMode;
    }

    public String getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(String retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public String getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(String idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public List<String> getNodeAddresses() {
        return nodeAddresses;
    }

    public void setNodeAddresses(List<String> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }
/*    @Bean
    @Autowired
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());


        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
      //  template.setEnableTransactionSupport(true);
        template.setValueSerializer(new ProtoSerializer());
        //template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }*/

}
