package geektime.tdd;

import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

/**
 * @author kim.yang
 * @date 2022/11/26 12:22 下午
 */
public class Main {


    public static void main(String[] args) throws Exception {
        JettyHttpContainerFactory
                .createServer(UriBuilder.fromUri("http://127.0.0.1/").port(8080).build(), new Application())
                .start();
    }

}
