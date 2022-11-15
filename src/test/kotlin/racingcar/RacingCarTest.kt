package racingcar

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import racingcar.domain.InputNumber

internal class RacingCarTest {
    @Test
    fun `횟수 0 이하 입력 시 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            InputNumber("-1")
        }
    }
}
