package step3.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingGameTest {
    @Test
    fun `RacingGame은 경주에 참하가는 자동차 대수와 전진 시도 횟수를 보관한다`() {
        val racingGame = RacingGame(
            numberOfCars = 3,
            numberOfAttempts = 5
        )

        assertAll(
            { assertThat(racingGame.numberOfCars).isEqualTo(3) },
            { assertThat(racingGame.numberOfAttempts).isEqualTo(5) }
        )
    }
}