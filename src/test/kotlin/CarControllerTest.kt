import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarControllerTest {

    @DisplayName("게임 플레이 테스트")
    @Test
    fun play() {
        val controller = CarController(4, 10)
        controller.play(ResultView())
    }
}
