#spring Cloud系统部署设计

EurekaServer 1000,1001 
ConfigServer 2000,2001  配置 centerService.name=xiafei
CenterService 3000,3001   提供SayHello服务
  
Zuul 5000,5001  网关服务 转发路径 /user/SayHello
