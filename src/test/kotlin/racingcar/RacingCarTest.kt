package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import racingcar.domain.InputName
import racingcar.domain.InputNumber

internal class RacingCarTest {
    @Test
    fun `횟수 0 이하 입력 시 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            InputNumber("-1")
        }
    }

    @Test
    fun `자동차 이름 입력이 정상적으로 된다`() {
        assertEquals("james", InputName("james").name)
    }

    @Test
    fun `자동차 이름 입력 시 공백이면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            InputName("")
        }
    }
}
