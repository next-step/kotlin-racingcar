package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `사칙연산 기호 경우 에러를 뱉지 않고 OperatorElement를 반환`(operator: String) {
        assertThat(Operator.parse(operator)).isInstanceOf(Operator::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["(", "1", "\n", "더하기", "\t", "X", ">", "plus"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(wrongOperator: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { Operator.parse(wrongOperator) }
            .withMessage("The value is not operator, value='$wrongOperator'")
    }

    @ParameterizedTest
    @CsvSource("0,0,0", "1,2,3", "-1,-3,-4", "4,-6,-2", "-5,8,3")
    fun `더하기`(a: Int, b: Int, result: Int) {
        assertThat(Operator.ADD.operate(Scalar(a), Scalar(b))).isEqualTo(Scalar(result))
    }

    @ParameterizedTest
    @CsvSource("0,0,0", "1,2,-1", "-1,-3,2", "4,-6,10", "-5,8,-13")
    fun `빼기`(a: Int, b: Int, result: Int) {
        assertThat(Operator.SUBTRACT.operate(Scalar(a), Scalar(b))).isEqualTo(Scalar(result))
    }

    @ParameterizedTest
    @CsvSource("0,0,0", "1,2,2", "-1,-3,3", "4,-6,-24", "-5,8,-40")
    fun `곱하기`(a: Int, b: Int, result: Int) {
        assertThat(Operator.MULTIPLY.operate(Scalar(a), Scalar(b))).isEqualTo(Scalar(result))
    }

    @ParameterizedTest
    @CsvSource("0,1,0", "5,3,1", "2,5,0", "4,-2,-2", "-50,8,-6")
    fun `나누기`(a: Int, b: Int, result: Int) {
        assertThat(Operator.DIVIDE.operate(Scalar(a), Scalar(b))).isEqualTo(Scalar(result))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 0, -2])
    fun `0으로 나누면 ArithmeticException throw`(a: Int) {
        Assertions.assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy { Operator.DIVIDE.operate(Scalar(a), Scalar(0)) }
            .withMessage("/ by zero")
    }
}
