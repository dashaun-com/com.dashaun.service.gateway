package local.gateway;

import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.LazyFuture;

import java.io.File;
import java.util.concurrent.Future;

public class BuildImageTest {
    private static final Future<String> IMAGE_FUTURE = new LazyFuture<>() {
        @Override
        protected String resolve() {
            // Find project's root dir
            File cwd;
            cwd = new File(".");
            while (!new File(cwd, "settings.gradle").isFile()) {
                cwd = cwd.getParentFile();
            }

            var imageName = String.format(
                    "gateway:%s",
                    System.currentTimeMillis()
            );

            // Run Gradle task and override the image name
            GradleRunner.create()
                    .withProjectDir(cwd)
                    .withArguments( "-x","test","-q", "bootBuildImage", "--imageName", imageName)
                    .forwardOutput()
                    .build();

            return imageName;
        }
    };

    @Container
    static final GenericContainer<?> APP = new GenericContainer<>(IMAGE_FUTURE)
            .withExposedPorts(8080);

    WebTestClient webClient;

    @BeforeEach
    void setUp() {
        APP.start();
        var endpoint = String.format(
                "http://%s:%d/",
                APP.getHost(),
                APP.getFirstMappedPort()
        );
        webClient = WebTestClient.bindToServer().baseUrl(endpoint).build();
    }

    @Test
    public void healthy() {
        webClient.get()
                .uri("/actuator/health")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}