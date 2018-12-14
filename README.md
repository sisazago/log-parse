# README

This README would normally document whatever steps are necessary to get your application up and running.

## Assumptions

All this configurations were made using:

* Eclipse Oxygen.3a Release (4.7.3a).
* MySQL 8
* Workbench 8.0.11 Community Edition.

## Steps for configuration

1.) Create an empty schema called `wallet_hub_log_parser`.

2.) Edit the pom.xml file in `database` module. Set the values for `jdbc.username` and `jdbc.password` properties to your database credentials. **Use the user and password for wallet_hub_log_parser database**.

3.) From the CLI execute:

```
# For wallet_hub_log_parser database
cd log-parser/log-parser-database
# Tests the connection
mvn flyway:info
# Executes the scripts to populate the wallet_hub_log_parser database
mvn flyway:migrate
```

4.) Edit the properties file `application.properties`, and modify the property log.path to indicate the path of the file