package demo.internet.speedpoll;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerRoutes.POLL_API)
@RequiredArgsConstructor
public class ProvidingAnswerController {
  private final ProvidingAnswerService providingAnswerService;

  @GetMapping
  public PollStatisticDTO getByAddress(@RequestParam String address) {
    Double averageSpeed = providingAnswerService.getAverageSpeed(address);
    Integer answersCount = providingAnswerService.getByCountAddress(address);
    return new PollStatisticDTO(averageSpeed, answersCount);
  }

  @PostMapping
  public void postAnswer(@RequestParam String address, @RequestParam Double speed) {
      providingAnswerService.save(address, speed);
  }

  @Data
  class PollStatisticDTO {
    private final Double averageSpeed;
    private final Integer answersCount;
  }

}
