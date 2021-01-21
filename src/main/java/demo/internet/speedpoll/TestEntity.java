package demo.internet.speedpoll;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class TestEntity {
  @Id
  private Integer id;

  public TestEntity() {
    id = new Random().nextInt();
  }
}
