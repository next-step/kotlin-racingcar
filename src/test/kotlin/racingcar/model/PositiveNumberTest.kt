package racingcar.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "200", "399", "411", "523"])
    fun `음수가 아닌 문자열 숫자 객체 생성 - 성공`(input: String) {
        assertDoesNotThrow {
            PositiveNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-200", "-399", "-411", "-523"])
    fun `음수가 아닌 문자열 숫자 객체 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            PositiveNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 200, 399, 411, 523])
    fun `음수가 아닌 숫자 객체 생성 - 성공`(input: Int) {
        assertDoesNotThrow {
            PositiveNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -200, -399, -411, -523])
    fun `음수가 아닌 숫자 객체 생성 - 실패`(input: Int) {
        assertThrows<IllegalArgumentException> {
            PositiveNumber(input)
        }
    }

    @Test
    fun `음수가 아닌 숫자의 더하기 기능 검증`() {
        val positiveNumber = PositiveNumber()
        val plusValue = 1
        positiveNumber.plus(plusValue)
        Assertions.assertEquals(plusValue, positiveNumber.getPositiveNumber())
    }

    @Test
    fun `숫자 비교`() {
        val positiveNumber1 = PositiveNumber("100")
        val positiveNumber2 = PositiveNumber("001")
        Assertions.assertEquals(1, positiveNumber1.compareTo(positiveNumber2))
    }
}
