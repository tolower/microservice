package com.xmair.core.configuration;


import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmair.core.util.ProtoSerializer;
import org.apache.velocity.runtime.directive.Foreach;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;


@Configuration
@ConfigurationProperties(prefix = "spring.redisson")
public class RedisConfig
{

    @Bean
    public RedissonClient initRedissonClient () {
        Config config = new Config();

        ClusterServersConfig serversConfig=config.useClusterServers();

        serversConfig.setReadMode(ReadMode.MASTER_SLAVE);
        serversConfig.setMasterConnectionMinimumIdleSize(masterConnectionMinimumIdleSize);
        serversConfig.setSlaveConnectionMinimumIdleSize(slaveConnectionMinimumIdleSize);
        serversConfig.setSubscriptionConnectionMinimumIdleSize(0);

        // 使用 lambda 表达式以及函数操作(functional operation)
        nodeAddresses.forEach((node) -> serversConfig.addNodeAddress(node));

        RedissonClient redisson = Redisson.create(config);
        return  redisson;
    }

    private  String readMode;

    private  String retryAttempts;

    private  String idleConnectionTimeout;



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
