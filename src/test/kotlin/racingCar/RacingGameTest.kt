package racingCar

import org.junit.jupiter.api.Test
import racingCar.lib.UserInputData

internal class RacingGameTest {

    @Test
    fun `자동차수 3 움직이는 수 5를 입력하면 자동차 경주를 세 번 실행한다`() {
        // given
        val userInput = UserInputData(3, 5)

        // when
        RacingGame(userInput).play()

        // then
        
    }
}