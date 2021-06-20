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