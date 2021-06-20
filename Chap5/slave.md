```bash
sudo apt update
sudo apt install mysql-server mysql-client
sudo mysql_secure_installation
sudo vim /etc/mysql/my.cnf
sudo service mysql restart

sudo mysql
sudo mysql petdatabase < petdatabase.sql 
CHANGE MASTER TO MASTER_HOST='192.168.56.7', MASTER_USER='slave_user', MASTER_PASSWORD='password', MASTER_LOG_FILE='mysql-bin.000001', MASTER_LOG_POS= 1776;
sudo mysql
cat petdatabase.sql 
sudo mysql petdatabase < ~/petdatabase.sql
sudo service mysql restart
sudo mysql

```