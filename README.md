# template
前后端分离脚手架，主要技术栈：SpringBoot3+Vue3
## 主要功能
- 用户注册登录
- 权限管理
- 文章管理
- 评论管理
- 个人中心
## 技术栈
- 后端：SpringBoot3、Spring Security、JWT、MyBatis-Plus
- 前端：Vue3、Vue Router、Vuex、Axios
## 项目结构
```
template
├── backend
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com.example.template
│   │   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── model
│   │   │       └── config
│   │   │   └── resources
│   │       ├── application.properties
│       └── mapper
├── frontend
│   ├── src
│   │   ├── components
│   │   ├── views
│   │   ├── router
│   │   ├── store
│   │   ├── App.vue
│   │   ├── main.js
│   │   ├── style.css
```
## 安装与运行
### 后端
1. 克隆仓库并进入backend目录
```bash
git clone https://github.com/yourusername/template.git
cd template/backend
```
2. 配置数据库连接
在application.properties中配置数据库连接信息
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/template?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
```
3. 运行后端应用
```bash
./mvnw spring-boot:run
```
./mvnw spring-boot:run
```
### 前端
1. 克隆仓库并进入frontend目录
```bash
git clone https://github.com/yourusername/template.git
cd template/frontend
```
2. 安装依赖
```bash
npm install
```
3. 运行前端应用
```bash
npm run dev
```
## 接口文档
- 后端接口文档：[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- 前端接口文档：[http://localhost:8080/api-docs](http://localhost:8080/api-docs)
## 贡献
- 欢迎提交Pull Request
- 请遵循代码规范
- 提交Pull Request时请提供详细的描述
## 许可证
- 本项目采用MIT许可证，详情请参阅LICENSE文件
## 联系方式
- 邮箱：[your.email@example.com](mailto:your.email@example.com)
- GitHub：[https://github.com/yourusername/template](https://github.com/yourusername/template)
## 版本历史
- v1.0.0 - 初始版本
- v1.1.0 - 添加了权限管理功能
- v1.2.0 - 优化了前端界面
## 未来计划
- 添加更多的功能模块，如消息通知、文件上传等
- 优化性能和安全性
- 支持更多的数据库类型，如PostgreSQL、MongoDB等
## 致谢
- 感谢所有贡献者的努力和支持
- 感谢开源社区提供的优秀资源和工具
## 免责声明
- 本项目仅供学习和参考使用，不得用于商业用途
- 使用本项目产生的任何问题和损失，作者不承担任何责任
## 相关链接
- 项目地址：[https://github.com/yourusername/template](https://github.com/yourusername/template)





