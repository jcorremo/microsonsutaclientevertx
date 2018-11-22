package io.vertx.clientes;

import io.vertx.clientes.httpserver.ClienteController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class ClienteVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteVerticle.class);
	
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		String verticleName = ClienteController.class.getName();
		DeploymentOptions options = new DeploymentOptions();
		options.setConfig(config());
		
		vertx.deployVerticle(verticleName, options, ar -> {
			if(ar.succeeded()) {
				LOGGER.info(String.format("Despliegue exitoso del verticle " + verticleName));
				startFuture.complete(); 
			}else {
				LOGGER.info(String.format("No se pudo desplegar el verticle " + verticleName));
				startFuture.fail(ar.cause());
			}
		});
	}
}
