package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.dtos.GameInput

class RacingGameTest {
    @Test
    fun `입력값을 받아 실행하면 결과를 리턴한다`() {
        val carNames = listOf("car1", "car2", "car3")
        val gameInput = GameInput(carNames, 5)

        val gameResult = RacingGame(gameInput).run()

        assertThat(gameResult.roundResults).hasSize(5).allMatch { it.cars.size == carNames.size }
    }
}
