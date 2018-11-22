FROM openjdk:8-jre-alpine
ENV VERTICLE_HOME /usr/verticles
EXPOSE 9000
COPY target/clientes-1.0.0-SNAPSHOT-fat.jar src/config/config.json build_and_run.sh $VERTICLE_HOME/
WORKDIR $VERTICLE_HOME
RUN apk update && apk add bash
RUN chmod +x build_and_run.sh
ENTRYPOINT ["./build_and_run.sh"]
#CMD ["exec java -jar $VERTICLE_FILE"]