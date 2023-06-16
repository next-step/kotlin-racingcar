package calculator

import calculator.exception.DivideByZeroException
import calculator.exception.IllegalSymbolException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource("+,ADD", "-,SUBTRACT", "*,MULTIPLY", "/,DIVIDE")
    fun `기호 문자에 맞는 Operator가 반환된다`(symbol: String, operator: Operator) {
        val foundOperator = Operator.findBySymbol(symbol)

        assertThat(foundOperator).isEqualTo(operator)
    }

    @Test
    fun `사칙연산 기호로만 Operator를 찾을 수 있다`() {
        assertThrows<IllegalSymbolException> { Operator.findBySymbol("?") }
    }

    @Test
    fun `기본 덧셈 테스트`() {
        val result = Operator.ADD.calculate(1F, 12F)

        assertThat(result).isEqualTo(13F)
    }

    @ParameterizedTest
    @CsvSource("1F,12F,-11F", "12F,1F,11F")
    fun `기본 뺄셈 테스트`(num1: Float, num2: Float, expect: Float) {
        val result = Operator.SUBTRACT.calculate(num1, num2)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource("1F,12F,12F", "1F,0F,0F", "3F,0.5F,1.5F")
    fun `기본 곱셈 테스트`(num1: Float, num2: Float, expect: Float) {
        val result = Operator.MULTIPLY.calculate(num1, num2)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource("10F,5F,2F", "3F,2F,1.5F")
    fun `기본 나눗셈 테스트`(num1: Float, num2: Float, expect: Float) {
        val result = Operator.DIVIDE.calculate(num1, num2)

        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `0으로 나누면 에러가 발생한다`() {
        assertThrows<DivideByZeroException> { Operator.DIVIDE.calculate(1F, 0F) }
    }
}
