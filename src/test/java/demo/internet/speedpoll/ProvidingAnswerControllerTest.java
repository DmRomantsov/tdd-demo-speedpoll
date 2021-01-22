package demo.internet.speedpoll;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringJUnitConfig
@WebMvcTest(ProvidingAnswerController.class)
@MockBean(ProvidingAnswerService.class)
public class ProvidingAnswerControllerTest {
  @Autowired
  private MockMvc mvc;
  @MockBean
  private ProvidingAnswerService answerService;

  @Test
  @SneakyThrows
  void postPoll() {
    // Given
    var address = "Amsterdam";
    var speed = 65;
    // Then
    mvc.perform(MockMvcRequestBuilders.post(ControllerRoutes.POLL_API)
        .param("address", address)
        .param("speed", String.valueOf(speed))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  @SneakyThrows
  void getPollStatisticByAddress() {
    // Given
    var address = "Amsterdam";
    var averageSpeed = 75.0;
    var answerCount = 5;
    when(answerService.getAverageSpeed(address)).thenReturn(averageSpeed);
    when(answerService.getByCountAddress(address)).thenReturn(answerCount);
    // Then
    mvc.perform(MockMvcRequestBuilders.get(ControllerRoutes.POLL_API)
        .queryParam("address", address)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.averageSpeed", closeTo(averageSpeed, 0.0001)))
        .andExpect(jsonPath("$.answersCount", equalTo(answerCount)));
  }
}
