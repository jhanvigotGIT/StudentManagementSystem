FROM tomcat:10.1-jdk21

WORKDIR /app

COPY . .

RUN apt-get update && \
    apt-get install -y ant && \
    rm -rf /var/lib/apt/lists/*

RUN ant -f build.xml dist

RUN rm -rf /usr/local/tomcat/webapps/ROOT && \
    cp dist/StudentManagement.war /usr/local/tomcat/webapps/StudentManagement.war

EXPOSE 8080

CMD ["catalina.sh", "run"]