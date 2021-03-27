package fiap.sjc.labs.rest.models;

import io.swagger.v3.oas.annotations.media.Schema;

public class Music {

  @Schema(description = "Identificador da música")
  private Integer id;

  @Schema(description = "Nome da música")
  private String name;

  @Schema(description = "Autor da música")
  private String author;

  @Schema(description = "Cantores da música")
  private String singer;

  @Schema(description = "Tamanho da música em segundos", defaultValue = "60")
  private Integer maxSeconds;

  public Music() {
  }

  public Music(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSinger() {
    return singer;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }

  public Integer getMaxSeconds() {
    return maxSeconds;
  }

  public void setMaxSeconds(Integer maxSeconds) {
    this.maxSeconds = maxSeconds;
  }

  @Override
  public String toString() {
    return "Music{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", author='" + author + '\'' +
            ", singer='" + singer + '\'' +
            ", maxSeconds=" + maxSeconds +
            '}';
  }
}
