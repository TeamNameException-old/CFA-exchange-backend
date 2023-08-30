### Документация к API [здесь](http://localhost:8080/docs)
### Точка входа: [http://localhost:8080/](http://localhost:8080/)
# Market
### Для успешного функционирования API необходимо:
1. Наличие языка программирования Java 
```shell
sudo apt install openjdk-17-jdk
```
2. Наличие сборщика проектов Maven
```shell
sudo apt install maven
```
3. Наличие СУБД PostgreSQL
```shell
sudo apt install postgresql postgresql-contrib
```
### *Обратите внимание на файл [application.properties](./src/main/resources/application.properties)*
#### Свойства ```spring.datasource.username``` и ```spring.datasource.password``` должны соответствовать username и password, необходимые для подключения к СУБД, соотвественно
## Запустите [api_prepare.sh](./api_prepare.sh), чтобы установить зависимости
## Используйте ```java -jar ./target/market-0.0.1.jar```, чтобы запустить проект