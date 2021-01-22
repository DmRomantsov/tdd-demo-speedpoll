package demo.internet.speedpoll;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(SpeedpollApplication.class)
public class ProvidingAnswerTest {

  private static final Random RANDOM = new Random();
  private static final String ADDRESS = "Kiev";
  private static final double SPEED1 = RANDOM.nextInt(30000) * RANDOM.nextDouble();
  private static final double SPEED2 = RANDOM.nextInt(30000) * RANDOM.nextDouble();

  @Autowired
  private ProvidingAnswerService providingAnswerService;
  @Autowired
  private AnswerRepository repository;

  @Test
  void usersAnswerSaved() {
    // When
    providingAnswerService.save(ADDRESS, SPEED1);
    // Then
    var answers = providingAnswerService.getAll();
    assertThat(answers.size()).isEqualTo(1);
    var answer = answers.get(0);
    assertThat(answer.getAddress()).isEqualTo(ADDRESS);
    assertThat(answer.getSpeed()).isEqualTo(SPEED1);
  }

  @Test
  void countByAddressCalculated() {
    // When
    providingAnswerService.save(ADDRESS, SPEED1);
    providingAnswerService.save(ADDRESS, SPEED2);
    // Then
    Integer answersCount = providingAnswerService.getByCountAddress(ADDRESS);
    assertThat(answersCount).isEqualTo(2);
  }

  @Test
  void averageByAddressCalculated() {
    // When
    providingAnswerService.save(ADDRESS, SPEED1);
    providingAnswerService.save(ADDRESS, SPEED2);
    // Then
    Double answers = providingAnswerService.getAverageSpeed(ADDRESS);
    assertThat(answers).isEqualTo((SPEED1+SPEED2)/2, Offset.offset(0.01));
  }

  @AfterEach
  void dbCleanUp() {
    repository.deleteAll();
  }
}
