### /hosts
本地测试，配置/etc/hosts
```
127.0.0.1       localhost,peer1,peer2,peer3
```

### 编译运行

##### 打包
```
mvn clean package
mvn clean install
```
##### 运行
```
java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1

java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2

java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3
```
再次访问 localhost:7001


