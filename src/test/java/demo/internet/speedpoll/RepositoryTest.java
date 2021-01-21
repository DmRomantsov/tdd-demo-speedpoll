package demo.internet.speedpoll;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@DataJpaTest
@SpringJUnitConfig
public class RepositoryTest {
  @Autowired
  private TestRepository repository;

  @Test
  public void saveAndRetrieveData() {
    var testEntity = new TestEntity();
    repository.save(testEntity);
    var list = repository.findAll();

    assertThat(list.size()).isEqualTo(1);
    assertThat(list.get(0)).isEqualTo(testEntity);
  }
}
