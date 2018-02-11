## 2018-2-11 更新日志
增加spring定时任务、mq示例
## 2018-2-9 更新日志
完善webapp拦截器，404错误处理，增加文件流处理示例
## 2018-2-8 更新日志
重构microservice项目结构，拆分出core webapp api job四个模块，测试打包
## 2018-2-8 更新日志
重构oauth项目结构，完善apiversion注解，对swagger友好支持，增加job模板




##spring boot开发框架目标
* 适应容器云环境
* 标准规范：java开发规范、应用集成开发规范（API开发规范、页面集成开发规范）、服务接入、分布式组件最佳实践、应用场景分析
* 高性能
* 安全性
* 简单易用
* 可运维监控






## 2018-2-6 更新日志
重构webconfig配置组件，增加apiversion


##我只是搬运工，站在巨人的肩膀上
##如无必要，勿重复发明轮子

# oauth2
spring boot +oltu搭建oauth sso的方案原型
主项目为spring boot整合案例，与oauth2无关。



##开发框架包含的组件功能
spring boot集成的组件包括但不限于：
* 运行环境：tomcat 相关jar包，无需再单独安装tomcat，简化开发部署
* 数据访问：推荐使用mybatis 、连接池druid
* 后台代码生成工具：mybaits gen，自动生成model、xml、mapper
* 数据库分页：pagehelper
* 通用mapper：完成
* 容器组件：spring 
* MVC： spring MVC
* 缓存：推荐redis
* 消息队列：rabbitmq、kafaka、rocketmq（推荐）
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


