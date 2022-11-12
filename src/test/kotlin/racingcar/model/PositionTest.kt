package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositionTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "200", "399", "411", "523"])
    fun `음수가 아닌 숫자 객체 생성 - 성공`(input: String) {
        assertDoesNotThrow {
            Position(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-200", "-399", "-411", "-523"])
    fun `음수가 아닌 숫자 객체 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            Position(input)
        }
    }

    @Test
    fun `음수가 아닌 숫자의 더하기 기능 검증`() {
        val position = Position()
        position.plus()
        assertEquals(1, position.value)
    }

    @Test
    fun `숫자 비교`() {
        val position1 = Position("100")
        val position2 = Position("001")
        assertEquals(1, position1.compareTo(position2))
    }
}
