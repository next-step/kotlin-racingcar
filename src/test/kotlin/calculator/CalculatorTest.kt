package calculator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @DisplayName("덧셈이 제대로 이루어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "0 + 5", "1 + 4", "2 + 3", "3 + 2", "4 + 1", "5 + 0" ])
    fun `check plus function`(input: String) {
        val calculator = Calculator()
        val result = calculator.arithmeticOperation(input)

        assertTrue(result == 5)
    }

    @DisplayName("뺄셈이 제대로 이루어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "10 - 5", "9 - 4", "8 - 3", "7 - 2", "6 - 1", "5 - 0" ])
    fun `check minus function`(input: String) {
        val calculator = Calculator()
        val result = calculator.arithmeticOperation(input)

        assertTrue(result == 5)
    }

    @DisplayName("나눗셈이 제대로 이루어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "24 / 12", "12 / 6", "6 / 3", "4 / 2", "2 / 1" ])
    fun `check divide function`(input: String) {
        val calculator = Calculator()
        val result = calculator.arithmeticOperation(input)

        assertTrue(result == 2)
    }

    @DisplayName("곱셈이 제대로 이루어지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "12 * 3", "3 * 12", "6 * 6", "1 * 36", "36 * 1", "2 * 18", "18 * 2", "4 * 9"])
    fun `check multiple function`(input: String) {
        val calculator = Calculator()
        val result = calculator.arithmeticOperation(input)

        assertTrue(result == 36)
    }

    @DisplayName("순서를 무시한 사칙연산이 정상적으로 이뤄지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "2 + 3 * 4 / 2" ])
    fun `check arithmeticOperation function`(input: String) {
        val convertor = Convertor()
        val calculator = Calculator(convertor)
        val result = calculator.arithmeticOperation(input)

        assertTrue(result == 10)
    }

    @DisplayName("입력값이 비거나 공백 문자일 경우 IllegalArgumentException throw하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "", " ", "          " ])
    fun `throw IllegalArgumentException when input is empty or blank`(input: String) {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException>("입력값이 null이거나 빈 공백이 아니여야합니다."){
            calculator.arithmeticOperation(input)
        }
    }

    @DisplayName("입력값이 null일 경우 IllegalArgumentException throw하는지 확인")
    @ParameterizedTest
    @NullSource
    fun `throw IllegalArgumentException when input is null`(input: String?) {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException>("입력값이 null이거나 빈 공백이 아니여야합니다.") {
            calculator.arithmeticOperation(input)
        }
    }
    @DisplayName("시작이나 끝이 숫자가 아닌 경우 IllegalArgumentExeption throw하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "1 +", "1 + 1 +", "+ 1 + 2"])
    fun `throw IllegalArgumentException when input's first or last word is not number`(input: String) {
        val calculator = Calculator()
        assertThrows<IllegalArgumentException>("수식의 시작 및 끝은 숫자여야합니다.") {
            calculator.arithmeticOperation(input)
        }
    }

    @DisplayName("허용된 사칙연산 기호 외의 문자나 기호가 들어가 있는 경우 IllegalArgumentException throw하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "1 A 2", "1 A 2 + 4", "1 % 2", "1 + 3 % 2"])
    fun `throw IllegalArgumentException when input's sign not in plus, minus, divide, multiple`(input: String) {
        val calculator = Calculator()
        assertThrows<IllegalArgumentException>{ calculator.arithmeticOperation(input) }
            .also { assertTrue(it.message!!.contains("은 허용되지않은 기호입니다.(+, -, *, / 만 허용됩니다.)")) }
    }

    @DisplayName("숫자 외의 문자가 들어가 있는 경우 NumberFormatException throw하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "2 + a / 1", "2 + 안녕 / 4", "0 + 3 * 🤣 / 1"])
    fun `throw NumberFormatException when input hasn't a number in even position`(input: String) {
        val calculator = Calculator()
        assertThrows<IllegalArgumentException> { calculator.arithmeticOperation(input) }
            .also { assertTrue(it.message!!.contains("은 숫자가 아닙니다"))  }

    }
    @DisplayName("숫자나 기호가 연속하여 나온 경우 IllegalArgumentException throw하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = [ "1 1 1 1", "1 + + 2", "1 + 2 2 + +"])
    fun `throw IllegalArgumentException when input has a continues number or sign`(input: String) {
        val calculator = Calculator()
        assertThrows<IllegalArgumentException> { calculator.arithmeticOperation(input) }
    }
}
