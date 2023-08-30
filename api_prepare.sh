sudo apt install openjdk-17-jdk maven postgresql postgresql-contrib -y
sudo systemctl start postgresql.service
mvn clean package