package fiap.sjc.labs.rest.controllers;

import fiap.sjc.labs.rest.exceptions.RecursoNaoEncontradoException;
import fiap.sjc.labs.rest.models.Music;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musics")
public class MusicController {

  private static final List<Music> REPOSITORIO = new ArrayList<>();

  static {
    REPOSITORIO.add(new Music(1, "Você"));
    REPOSITORIO.add(new Music(2, "Oceano"));
    REPOSITORIO.add(new Music(3, "Faroeste caboclo"));
    REPOSITORIO.add(new Music(4, "enter sandman"));
    REPOSITORIO.add(new Music(5, "Imagine"));
    REPOSITORIO.add(new Music(6, "Smells Like Teen Spirit"));
  }

  // GET ALL
  @GetMapping
  @Operation(summary = "Listar todos", description = "Lista todas as músicas cadastradas")
  public List<Music> listAll() {
    return REPOSITORIO;
  }

  // GET BY ID
  @GetMapping("/{id}")
  @Operation(summary = "Listar por ID", description = "Busca uma música a partir de um identificador")
  public Music getById(@PathVariable @Parameter(description = "Identificador da Música") final Integer id) {
    Optional<Music> music = REPOSITORIO.stream().filter(m -> {
      return id.equals(m.getId());
    }).findFirst();

    if (!music.isPresent()) {
      throw new RecursoNaoEncontradoException("Recurso Music, id " + id);
    }

    return music.get();
  }

  // POST
  @PostMapping
  public ResponseEntity<Music> create(@RequestBody final Music music) {
    REPOSITORIO.add(music);
    return ResponseEntity
            .created(URI.create("/musics/" + music.getId()))
            .body(music);
  }


  // PUT
  @PutMapping("/{id}")
  public void update(@PathVariable final Integer id, @RequestBody final Music music) {

  }


//
//  // DELETE
//  @DeleteMapping
//  public void delete(final Integer id) {
//  }

}
