package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {

    @Test
    fun `올바른 operator가 선택되는지 확인한다`() {
        val oldNum = 4.0
        val newNum = 2.0

        assertEquals(6.0, Operator.calculate("+", oldNum, newNum))
        assertEquals(2.0, Operator.calculate("-", oldNum, newNum))
        assertEquals(8.0, Operator.calculate("*", oldNum, newNum))
        assertEquals(2.0, Operator.calculate("/", oldNum, newNum))
    }

    @Test
    fun `올바르지 않은 사칙연산 기호가 전달될 경우 예외를 발생한다`() {
        val oldNum = 4.0
        val newNum = 2.0

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operator.calculate("a", oldNum, newNum) }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operator.calculate("&", oldNum, newNum) }
    }

    @ParameterizedTest
    @CsvSource(
        "3, 5, 8",
        "4.0, 15.2, 19.2",
        "1, 5, 6"
    )
    fun `더하기 테스트`(oldNum: Double, newNum: Double, result: Double) {
        assertEquals(result, AddOperator.operate(oldNum, newNum))
    }

    @ParameterizedTest
    @CsvSource(
        "3, 5, -2",
        "4.0, 15.2, -11.2",
        "5, 1, 4"
    )
    fun `빼기 테스트`(oldNum: Double, newNum: Double, result: Double) {
        assertEquals(result, MinusOperator.operate(oldNum, newNum))
    }

    @ParameterizedTest
    @CsvSource(
        "3, 5, 15",
        "4, 15.2, 60.8",
        "1, 5, 5"
    )
    fun `곱하기 테스트`(oldNum: Double, newNum: Double, result: Double) {
        assertEquals(result, MultipleOperator.operate(oldNum, newNum))
    }

    @ParameterizedTest
    @CsvSource(
        "15, 5, 3",
        "4.2, 2.1, 2",
        "10, 8, 1.25"
    )
    fun `나누기 테스트`(oldNum: Double, newNum: Double, result: Double) {
        assertEquals(result, DivideOperator.operate(oldNum, newNum))
    }
}
