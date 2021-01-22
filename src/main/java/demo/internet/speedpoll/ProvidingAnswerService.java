package demo.internet.speedpoll;

import java.util.List;

public interface ProvidingAnswerService {

  void save(String address, double speed);

  List<Answer> getAll();

  Integer getByCountAddress(String address);

  Double getAverageSpeed(String address);
}
