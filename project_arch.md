#项目架构

## 组件化
    项目整体基于组件化开发, (module)app作为壳工程入口, 集成各module, 自身不承担任何业务.
    component_base是项目的基础组件, 包括MVVM架构的base封装, 第三方library集中管理等功能. 自身不承担任何业务, 仅为上层module提供服务.
    其他module为业务组件, 基于具体业务划分. 业务组件彼此之间无任何依赖, 通过路由互相通信
    
## module_pass 密码相关业务

## module_setting 设置相关业务


    