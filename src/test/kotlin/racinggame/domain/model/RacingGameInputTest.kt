package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingGameInputTest {
    @Test
    fun `RacingGameInput은 경주에 참하가는 자동차 대수와 전진 시도 횟수를 보관한다`() {
        val racingGameInput = RacingGameInput(
            numberOfCars = 3,
            numberOfAttempts = 5
        )

        assertAll(
            { assertThat(racingGameInput.numberOfCars).isEqualTo(3) },
            { assertThat(racingGameInput.numberOfAttempts).isEqualTo(5) }
        )
    }
}
