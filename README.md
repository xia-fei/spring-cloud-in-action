#spring Cloud系统部署设计

EurekaServer 1000,1001 
ConfigServer 2000,2001  配置 centerService.name=xiafei
CenterService 3000,3001   提供SayHello服务
  
Zuul 5000,5001  网关服务 转发路径 /user/SayHello






# 问题解决
## 通用问题
有时application.yml文件没生效。尝试 mvn clean
## configServer
### 问题1 ssh连接方式 reject HostKey
Ant com.jcraft.jsch.JSchException: reject HostKey

### 解决
添加远程主机公钥到信任列表
`ssh-keyscan -t ssh-rsa -p 65321 git.carzone365.com >> ~/.ssh/known_hosts`


### 问题2 ssh默认位置的 密钥无法身份验证
 com.jcraft.jsch.JSchException: Auth fail ~/.ssh/id_rsa 这个默认的私钥无法证明身份

### 解决
org.eclipse.jgit.transport.OpenSshConfig.lookup()这个方法源代码表示
需要在~/.ssh/config里面 对要用的这个host配置下`IdentityFile`
例如
```
Host github.com
HostName github.com
IdentityFile ~/.ssh/github.pem
```
它会通过spring.cloud.config.server.git.uri里的host去匹配 config文件里的Host 用IdentityFile做ssh登陆
官网是这么写的
If you do not use HTTPS and user credentials, SSH should also work out of the box when you store keys in the default directories (~/.ssh) and the  URI points to an SSH location, such as git@github.com:configuration/cloud-configuration




## EurekaClient服务发现不及时

EurekaServer->EurekaClient: eureka.client.registryFetchIntervalSeconds
EurekaClient->Ribbon:  ribbon.ServerListRefreshInterval

EurekaClient->EurekaServer: 心跳eureka.instance.lease-renewal-interval-in-seconds

参考文档  
[https://blog.csdn.net/weixin_45132238/article/details/93617754](https://blog.csdn.net/weixin_45132238/article/details/93617754)

## 重试解决 服务发布时错误问题
ribbon.OkToRetryOnAllOperations:true 
#(是否所有操作都重试，若false则仅get请求重试)
ribbon.MaxAutoRetriesNextServer:3 
#(重试负载均衡其他实例最大重试次数,不含首次实例)
ribbon.MaxAutoRetries:1
