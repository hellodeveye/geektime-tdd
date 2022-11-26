package geektime.tdd;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author kim.yang
 * @date 2022/11/26 12:31 下午
 */
public class Application extends ResourceConfig {
    public Application() {
        packages("geektime.tdd.resource");
    }
}
