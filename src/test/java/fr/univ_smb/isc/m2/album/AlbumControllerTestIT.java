package fr.univ_smb.isc.m2.album;

import fr.univ_smb.isc.m2.config.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class AlbumControllerTestIT {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate template;

    @Autowired
    private AlbumRepository repository;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
        repository.save(new Album("Shades of Deep Purple", 1968));
        repository.save(new Album("Deep Purple", 1969));
        repository.save(new Album("Fireball", 1971));
        repository.save(new Album("Stormbringer", 1974));
    }

    @Test
    public void shouldGetAlbumFromDatabase() throws Exception {
        URL url = new URL("http://localhost:" + port + "/albums/3");
        ResponseEntity<String> response = template.getForEntity(url.toString(), String.class);
        assertThat(response.getBody(), equalTo("{\"id\":3,\"title\":\"Fireball\",\"year\":1971}"));
    }

}