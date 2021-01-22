package demo.internet.speedpoll;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
  int countByAddress(String address);
  List<Answer> findByAddress(String address);
}
