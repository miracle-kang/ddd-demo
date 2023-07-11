# DDD(Domain-Drive Design) Demo

DDD演示项目，基于Spring Cloud实现

## service-registry

服务注册中心

## config-server

服务配置中心，配置文件基于本项目`.cloud-demo-config`目录

## api-gateway

API 网关

## identity

身份认证服务

## access

访问权限服务

## infrastructure

基础设施，被各个服务依赖使用

## Build And Run

项目基于docker和docker-compose，所有服务编排的默认配置都在docker-compose.yml文件中

#### dependencies

需要先安装maven、docker和docker-compose

#### run
```shell script
# 打包
mvn package

# 使用docker-compose启动项目
docker-compose up -d --build
```
