FROM tomcat:10.1-jdk21

RUN apt-get update && \
    apt-get install -y ant && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN ant -f build.xml -Dj2ee.server.home=/usr/local/tomcat dist

RUN cp dist/StudentManagement.war /usr/local/tomcat/webapps/StudentManagement.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
