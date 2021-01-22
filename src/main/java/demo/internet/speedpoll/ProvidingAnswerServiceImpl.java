package demo.internet.speedpoll;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProvidingAnswerServiceImpl implements ProvidingAnswerService {
  private final AnswerRepository answerRepository;

  @Override
  public void save(String address, double speed) {
    answerRepository.save(new Answer(address, speed));
  }

  @Override
  public List<Answer> getAll() {
    return answerRepository.findAll();
  }

  @Override
  public Integer getByCountAddress(String address) {
    return answerRepository.countByAddress(address);
  }

  @Override
  public Double getAverageSpeed(String address) {
    List<Answer> answers = answerRepository.findByAddress(address);
    return answers.stream()
        .map(Answer::getSpeed)
        .reduce(0.0, Double::sum) / answers.size();
  }
}
