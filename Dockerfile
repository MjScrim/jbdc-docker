FROM postgres:15

ENV POSTGRES_USER=root
ENV POSTGRES_PASSWORD=root
ENV POSTGRES_DB=jdbcDB

COPY init.sql /docker-entrypoint-initdb.d/init.sql

EXPOSE 5432


