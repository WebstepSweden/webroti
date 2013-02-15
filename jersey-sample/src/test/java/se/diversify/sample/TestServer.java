package se.diversify.sample;

import com.sun.jersey.api.container.ContainerFactory;
import com.sun.jersey.api.core.ApplicationAdapter;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.ServerConfiguration;

/**
 * @author Christer Sandberg, Diversify Stockholm.
 */
public final class TestServer {

    public static void main(String[] args) throws Exception {
        HttpServer httpServer = new HttpServer();

        ServerConfiguration config = httpServer.getServerConfiguration();


        ApplicationAdapter rc = new ApplicationAdapter(new SampleApplication());
        HttpHandler resourcesHandler = ContainerFactory.createContainer(HttpHandler.class, rc);
        config.addHttpHandler(resourcesHandler, "/resources/");

        NetworkListener networkListener = new NetworkListener("jersey-sample-server", "localhost", 4040);

        httpServer.addListener(networkListener);
        httpServer.start();
        try {
            System.out.println("WADL available at:");
            System.out.println("http://localhost:4040/resources/application.wadl");
            System.out.println("Press 'Enter' to exit the server...");
            System.in.read();
        } finally {
            httpServer.stop();
        }
    }

}
