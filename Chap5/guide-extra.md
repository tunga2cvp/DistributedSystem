### 1 - Setup virtual machine using VirtualBox

- Configuration:
  - 4GB for memory
  - 25GB for disk
  - Using ubuntu-desktop-20.04
- Start the VM and execute the OS installation
- Turn off the VM to set up network adapter
  - NAT
  - Bridge
  - Host
- Restart then install few support infrastructure:
  - vim
  - openssh
  - ifconfig



### 2 - Install MySQL
2.1 Install repository and initialize authentication
```bash
sudo apt-get update
sudo apt-get install mysql-server mysql-client
sudo mysql_secure_installation
# to simplify, get the least complicated option
```
2.2 Configure 

```bash
cat < EOF | echo 2 | sudo tee /etc/mysql/my.cnf
!includedir /etc/mysql/conf.d/
!includedir /etc/mysql/mysql.conf.d/

[mysqld]
bind-address = 192.168.56.7
server-id = 1
log_bin = /var/log/mysql/mysql-bin.log
binlog_do_db = petdatabase
EOF
```
2.3 Restart and access
```bash
# after modify cfg file, restart the service
sudo service mysql restart
```
```bash
# since now, login mysql is simple as following
sudo mysql
```

### 3 - Configure slave user

There are a few sql commands that need to modified to prevent later error and new version's syntax difference.

```bash
sudo mysql
...
mysql> CREATE USER 'slave_user'@'%' IDENTIFIED WITH mysql_native_password BY 'password';
mysql> GRANT REPLICATION SLAVE ON *.* TO 'slave_user'@'%';
...
mysql> SET GLOBAL local_infile=1;
mysql> quit;
sudo mysql --local-infile=1
```

### 4 - Debug

- To stop the slave replication task of MySQL

```sql
stop slave;
stop slave io_thread;
stop slave sql_thread;
```



