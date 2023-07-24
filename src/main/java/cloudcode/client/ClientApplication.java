package cloudcode.client;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** This class serves as an entry point for the Spring Boot app. */
@SpringBootApplication
public class ClientApplication {

  private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

  public static void main(final String[] args) throws Exception {
    String port = System.getenv("PORT");
    if (port == null) {
      port = "8081";
      logger.warn("$PORT environment variable not set, defaulting to 8080");
    }
    SpringApplication app = new SpringApplication(ClientApplication.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", port));

    // Start the Spring Boot application.
    app.run(args);
    System.out.println("-------------------------------------------");
    System.out.println("http://localhost:"+port);
    // logger.info(
    //     "Hello from Cloud Run! The container started successfully and is listening for HTTP requests on " + port);
  }
}
