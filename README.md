

## spring boot开发框架目标
* 适应容器云环境
* 标准规范：java开发规范、应用集成开发规范（API开发规范、页面集成开发规范）、服务接入、分布式组件最佳实践、应用场景分析
* 高性能
* 安全性
* 简单易用
* 可运维监控


## 2018-5-29 更新日志
1、重构日志、异常、API开发规范

## 2018-5-23 更新日志
1、增加rocketmq测试用例
2、zipkin 日志写入kafka；业务日志写入kafka，通过traceid进行关联
2、修复consul  discovery的坑：当3个server节点组成的consul集群，挂掉一个时，其上注册的service实例，状态就无法刷新了。
这个没什么问题，要结合ribbon 重试机制即可。
有问题的是spring cloud consul discovery的实现，官方实现的serverlistfilter首先会判断consul server的状态，如果状态critical，则直接返回false。就不再考虑service实例本身的状态了。
这种机制容错性太差了。解决办法：自定义filter替换掉官方的，只判断service 的状态。


## 2018-4-20 更新日志
1、prometheus客户端替代actuator，暴露prometheus性能监控接口，添加prometheus拦截器收集性能数据
2、测试redis分布式集群密码模式

## 2018-4-12 更新日志
1、在rancher中搭建redis cluster，配置文件详见core模块下的dev配置文件
2、redisson对分布式支持良好，弃用jedis、spring-data-redis

## 2018-2-27 更新日志
1、返回统一的数据格式ResultBean，考虑异常返回
2、参数中不能出现 jsonstring  map之类的复杂参数
3、create应该返回新对象的id标识
4、Controller做参数格式的转换，不允许把json，map这类对象传到services去，也不允许services返回json、map
5、参数中一般情况不允许出现Request，Response这些对象
6、controller不允许catch 异常，抛出BIZexception，统一交给aop进行最后的处理
7、后台异常一定要有通知机制
8、修改新增操作必须打印日志
9、在controlleradvice中统一处理参数校验异常


## 2018-2-26 更新日志
1、整理数据校验、restapi最佳开发实践
2、velocity代码生成替换mybatis gen，可自定义。支持model、xml、mapper、restapi。
支持swagger、数据校验等特性

## 2018-2-23 更新日志
1、研究grpc，undertow、okhttp等。
2、undertow替换tomcat。spring boot默认集成的容器有tomcat、jetty、undertow，后两个都是轻量高性能的服务器，undertow性能更佳
3、对grpc  http服务调用做性能测试
新增grpc、grpc-client两个试验模块。
简单测试结果：grpc网络平均耗时1毫秒，网上公开测评的结论是dubbo略优于grpc
     tomcat+httpclient 3-5毫秒
     undertow+okhttp 平均耗时1毫秒，经常能跑出比grpc更高的性能，结果令人满意。接下来做大并发测试
经过优化后的http性能已接近rpc，而且将来可升级为http2.0协议，暂不继续深入研究grpc等rpc框架。

4、研究http2协议
http2可以运行在ssl之上，简称h2
也可以运行在http上，简称h2c（明文未加密）
目前大部分服务器、客户端基本实现h2，较少实现了h2c。详见
https://github.com/http2/http2-spec/wiki/Implementations
鉴于undertow+okhttp性能已足够好，暂不继续深入研究http2协议，等时机成熟再引入，保持关注。

5、试用rancher容器管理平台
重新部署了redis 容器、mysql实例，配置文件详见
core/src/main/resources/application-dev.properties



## 2018-2-11 更新日志
增加spring定时任务、mq示例
## 2018-2-9 更新日志
完善webapp拦截器，404错误处理，增加文件流处理示例
## 2018-2-8 更新日志
重构microservice项目结构，拆分出core webapp api job四个模块，测试打包
## 2018-2-8 更新日志
重构oauth项目结构，完善apiversion注解，对swagger友好支持，增加job模板

## 2018-2-6 更新日志
重构webconfig配置组件，增加apiversion


## 我只是搬运工，站在巨人的肩膀上
## 如无必要，勿重复发明轮子

# oauth2
oauthserver 、client为spring boot +oltu搭建oauth sso的方案原型

# 工程模块说明
* core为基础核心模块，常用工具类的封装，业务代码
* restapi为微服务
* webapp为网站
* job作业模块
* 后续将新增mobile模块

##开发框架包含的组件功能
spring boot集成的组件包括但不限于：
* 运行环境：默认集成tomcat jar包，此外还包括jetty  undertow，undertow最为轻量高性能，选择undertow
* 数据访问：推荐使用mybatis 、连接池druid
* 后台代码生成工具：mybaits gen，自动生成model、xml、mapper
* 数据库分页：pagehelper
* 通用mapper：完成
* 容器组件：spring 
* MVC： spring MVC
* 缓存：集成redis
* 消息队列：rocketmq（推荐），rabbitmq、kafaka、
* 前端模板：推荐使用thymeleaf，这是官方推荐的模板（不推荐采用jsp），便于docker镜像打包部署，大家统一一下
* restApi: spring MVC、 swagger、版本规范
* 二进制序列化：应用间通信推荐使用protobuf，压缩比高、性能卓越，可运用在restapi调用、redis缓存存取等场景
* json序列化：推荐使用jackson，功能完善，现版本与fastjson差不多，fastjson很多特殊场景不支持
* 日志： 推荐使用logback、日志存储es
* 全局异常处理：RestExceptionHandler捕获未处理的异常
* 业务异常处理模块：errorcode的编制（还不完善）
* 运维监控：spring boot admin（尚未完成）
* 后台校验：利用hibernate validator，常见web安全措施
* 单元测试：junit
* 二进制流处理：文件存取
* 定时任务：quartz
* 前端UI集成：开放，推荐vue，pcweb应用采用jquery+bootstrap也可
* 安全认证：可利用oauth2.0的开源组件oltu实现单点登录SSO（针对人员）、api调用者token认证（针对应用）


