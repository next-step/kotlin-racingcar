package study.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingGameApplicationTest {
    @Test
    internal fun `4 이상인 경우 움직일 수 있는지`() {
        data class TestData(val rpm: Int, val expected: Boolean)
        IntRange(0, 9).map { rpm ->
            TestData(rpm, rpm >= 4)
        }.forEach { (rpm, expected) ->
            assertThat(Car().canMove(rpm)).isEqualTo(expected)
        }
    }
}
