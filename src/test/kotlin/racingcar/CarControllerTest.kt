package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.CarController

class CarControllerTest {

    @DisplayName("게임 플레이 테스트")
    @Test
    fun play() {
        val controller = CarController(listOf("cat", "dog", "lion"), 10)
        controller.startGame()
    }
}
