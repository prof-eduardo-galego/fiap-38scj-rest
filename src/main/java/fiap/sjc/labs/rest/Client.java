package fiap.sjc.labs.rest;

import fiap.sjc.labs.rest.models.Music;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Client {

  public static void main(String... args) {

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<Music>> response = restTemplate.exchange(
            "http://localhost:8080/musics/",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Music>>() {
            });
    List<Music> musics = response.getBody();
    System.out.println(musics.toString());
  }

}
