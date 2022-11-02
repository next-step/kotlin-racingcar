package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTests {
    private var stringCalculator: StringCalculator? = null

    @BeforeEach
    fun setUp() {
        stringCalculator = StringCalculator()
    }

    @ParameterizedTest
    @CsvSource(delimiterString = "=", value = ["2 + 3 * 4 / 2=10", "2 * 3 / 4 - 2=-1", "2 / 3 + 4 * 2=8"])
    fun `정상 작동 확인`(expression: String?, expected: Int?) {
        Assertions.assertThat(stringCalculator!!.calculate(expression)).isEqualTo(expected)
    }

    @ParameterizedTest
    @EmptySource
    fun `입력값이 널이거나 비어있을 경우`(emptyExpression: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator!!.calculate(emptyExpression) }
            .withMessageStartingWith(ErrorMessage.NULL_OR_BLANK.toString())
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 : 3 * 4 / 2", "2 * 3 / 4 ! 2", "2 / 3 = 4 - 2"])
    fun `사칙연산 기호가 아닌 경우`(expressionContainingInvalidOperator: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator!!.calculate(expressionContainingInvalidOperator) }
            .withMessageStartingWith(ErrorMessage.INVALID_OPERATOR.toString())
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / x", "2 * x / 4 - 2", "x / 3 + 4 - 2"])
    fun `피연산자가 숫자가 아닐 경우`(expressionContainingInvalidOperand: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator!!.calculate(expressionContainingInvalidOperand) }
            .withMessageStartingWith(ErrorMessage.INVALID_NUMBER_FORMAT.toString())
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / ", "2 * 3 / 4 -  ", "2 / 3 + 4 - "])
    fun `피연산자가 숫자가 모자랄 경우`(expressionContainingInvalidOperand: String?) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { stringCalculator!!.calculate(expressionContainingInvalidOperand) }
            .withMessageStartingWith(ErrorMessage.NOT_ENOUGH_OPERAND.toString())
    }
}
