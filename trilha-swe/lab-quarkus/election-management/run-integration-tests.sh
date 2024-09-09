#!/bin/bash

./mvnw verify '-DskipITs=false' '-Dquarkus.log.handler.gelf.enabled=false' '-Dquarkus.opentelemetry.enabled=false' '-Dquarkus.datasource.jdbc.driver=org.mariadb.jdbc.Driver'