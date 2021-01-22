package demo.internet.speedpoll;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
public class Answer {
  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, updatable = false, unique = true)
  private Long id;
  @NotNull
  @Size(min=2, max=255)
  private String address;
  @Min(0)
  @NonNull
  private Double speed;

  public Answer(String address, Double speed) {
    this.address = address;
    this.speed = speed;
  }
}
