package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

internal class RacingGameTest {
    @Test
    internal fun `모든 자동차가 전진이 나왔을 때 score가 전부 1이 되었는지 확인`() {
        val records = RacingGame.play(
            3,
            GameRecords(CarFactory.manufacture(3)),
            object : MoveStrategy {
                override fun move(): Boolean {
                    return true
                }
            }
        )

        SoftAssertions.assertSoftly {
            assertThat(records.cars.size).isEqualTo(3)
            assertThat(records.cars[0].score).isEqualTo(1)
            assertThat(records.cars[1].score).isEqualTo(1)
            assertThat(records.cars[2].score).isEqualTo(1)
        }
    }
}
