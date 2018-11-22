FROM openjdk:8-jre-alpine
ENV VERTICLE_HOME /usr/verticles
COPY target/clientes-1.0.0-SNAPSHOT-fat.jar $VERTICLE_HOME/
COPY src/config/config.json $VERTICLE_HOME/
COPY build_and_run.sh $VERTICLE_HOME/
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["./build_and_run.sh"]
#CMD ["exec java -jar $VERTICLE_FILE"]