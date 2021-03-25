FROM java:8

MAINTAINER LIHUI <994936040@qq.com>

COPY *.jar /service-bobcat.jar

CMD ["--server.port=7771"]

EXPOSE 7771

ENTRYPOINT ["java","-jar","/service-bobcat.jar"]