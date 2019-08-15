# tmri-plate

spring-cloud-netfiix-oss

spring cloud 快速框架

spring boot版本：2.1.6.RELEASE

spring cloud版本：Greenwich.SR1

## Tmri-Plate模块说明

![](http://temp.oasestea.com/Fruf5juRqdDs2CGlg1hR56wMEsCc)

## Tmri-Plate服务端口说明 

|服务名称|网址|
|--|--|
|注册中心|http://localhost:8000|
|网关|http://localhost:8888|
|管理|http://localhost:8001
|监控|http://localhost:8002/hystrix
|服务|用户服务：http://localhost:9001/user
|   |测试服务：http://localhost:9002/test

## Tmri-Plate架构
 
 ![](http://temp.oasestea.com/Fj6b-WOM6LdaXp_x0-RRiaSVVKjj)

## Tmri-Plate分模块说明

### 平台网关（tmri-plate-zuul）

网关:spring-cloud-netflix-zuul

启动：TmriPlateZuulApplication

服务网址:http://localhost:8888


### 平台服务注册和发现（tmri-plate-eureka）

网关:spring-cloud-netflix-eureka

启动：TmriPlateEurekaApplication

服务网址:http://localhost:8000

![](http://temp.oasestea.com/Fv6D_4JCF0Vmugejl_YTbEwvDoWo)
 
## tmri-plate-config: 平台配置中心

### 平台管理（tmri-palte-manager）

#### tmri-plate-admin: 平台日志管理，硬件，微服务监控状态监

启动：TmriPlateAdminApplication

访问：http://localhost:8001

 ![](http://temp.oasestea.com/FkkD5WN3uno92fF_CJa_GOo0nOTg)

### tmri-plate-turbine: 平台熔断监控

为保证微服务的可用性，防止微服务出错导致网络阻塞，出现了断路器模型。
有很多个微服务的时候，这就需要用Turbine聚合所有服务的Hystrix Dashboard。

启动：TmriPlateTurbineApplication
访问：http://localhost:8002/hystrix

### 业务微服务（tmri-plate-modules）

service-user: 用户服务
service-common：公共服务
service-test：测试服务



