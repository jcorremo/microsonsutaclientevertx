package io.vertx.clientes.httpserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.clientes.model.Customer;

public class ClienteController extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

	@Override
	public void start(Future<Void> future) throws Exception {
		MongoClient mongoClient = MongoClient.createNonShared(vertx, config().getJsonObject("mongo"));
		Router router = Router.router(vertx);
		String host = config().getString("vertx.host", "0.0.0.0");
		int port = config().getInteger("vertx.port", 9000);

		router.get("/").handler(rc -> {
			rc.response().end("try with /clientes or /clientes/:id");
		});

		router.get("/clientes").handler(rc -> {
			mongoClient.find("customer", new JsonObject(), resultHandler -> {
				List<JsonObject> objects = resultHandler.result();
				List<Customer> customers = objects.stream().
						filter(x -> x.getString("tipoIdentificador").equals("7")).
						map(Customer::new).collect(Collectors.toList());
				rc.response()
		         .putHeader("content-type", "application/json; charset=utf-8")
		          .end(Json.encodePrettily(customers));
			});
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(port, host, ar -> {
			if (ar.succeeded()) {
				future.complete();
				LOGGER.info(String.format("Verticle http corriendo en el puerto" + port));
			} else {
				future.fail(ar.cause());
				LOGGER.info(String.format("Verticle no se puto levantar en el puerto" + port));
			}
		});
	}	
}
