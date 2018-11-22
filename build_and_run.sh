#!/usr/bin/env bash
echo $(pwd)
echo $(ls -ltr)
JMX_OPTIONS="-Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=7778 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=paradigma.cursovertx "
#mvn clean package -DskipTests 
java $JMX_OPTIONS -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory -jar clientes-1.0.0-SNAPSHOT-fat.jar -conf config.json  
