package racingcar.etc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NonNegativeTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "200", "399", "411", "523"])
    fun `음수가 아닌 숫자 객체 생성 - 성공`(input: String) {
        assertDoesNotThrow {
            NonNegative(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-200", "-399", "-411", "-523"])
    fun `음수가 아닌 숫자 객체 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            NonNegative(input)
        }
    }

    @Test
    fun `음수가 아닌 숫자의 더하기 기능 검증`() {
        val nonNegative = NonNegative()
        nonNegative.plus()
        assertEquals(1, nonNegative.toInt())
    }

    @Test
    fun `숫자 비교`() {
        val nonNegative1 = NonNegative("100")
        val nonNegative2 = NonNegative("001")
        assertEquals(1, nonNegative1.compareTo(nonNegative2))
    }
}
