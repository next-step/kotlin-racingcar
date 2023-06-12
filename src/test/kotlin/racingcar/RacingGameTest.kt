package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

internal class RacingGameTest {
    @Test
    internal fun `모든 자동차의 게임결과가 전진이 나왔을 때 score가 전부 1이 되었는지 확인`() {
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

    @Test
    internal fun `모든 자동차의 게임 결과가 전진이 나오지 않았을 때 score가 전부 0이 되었는지 확인`() {
        val records = RacingGame.play(
            2,
            GameRecords(CarFactory.manufacture(2)),
            object : MoveStrategy {
                override fun move(): Boolean {
                    return false
                }
            }
        )

        SoftAssertions.assertSoftly {
            assertThat(records.cars.size).isEqualTo(2)
            assertThat(records.cars[0].score).isEqualTo(0)
            assertThat(records.cars[1].score).isEqualTo(0)
        }
    }
}
