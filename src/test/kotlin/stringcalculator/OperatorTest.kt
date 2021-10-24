package stringcalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @Test
    fun `ADD 실행 시 두 값을 더한 결과를 리턴한다`() {
        val operational = Operational(1, 2)

        val result = Operator.ADD.execute(operational)

        Assertions.assertThat(result).isEqualTo(1 + 2)
    }

    @ParameterizedTest
    @CsvSource(*["2, 1", "1, 2"])
    fun `SUBTRACT 시 두 값의 차를 구한 결과를 리턴한다`(left: Int, right: Int) {
        val operational = Operational(left, right)

        val result = Operator.SUBTRACT.execute(operational)

        Assertions.assertThat(result).isEqualTo(left - right)
    }

    @ParameterizedTest
    @CsvSource(*["2, 1", "1, 2"])
    fun `DIVIDE 실행 시 두 값을 나눈 결과를 리턴한다`(left: Int, right: Int) {
        val operational = Operational(left, right)

        val result = Operator.DIVIDE.execute(operational)

        Assertions.assertThat(result).isEqualTo(left / right)
    }

    @Test
    fun `DIVIDE 실행 시 0으로 나누는 경우 ArithmeticException 에러를 일으킨다`() {
        val operational = Operational(2, 0)

        assertThrows<ArithmeticException> {
            Operator.DIVIDE.execute(operational)
        }
    }

    @Test
    fun `MULTIPLY 실행 시 두 값을 곱한 결과를 리턴한다`() {
        val operational = Operational(2, 3)

        val result = Operator.MULTIPLY.execute(operational)

        Assertions.assertThat(result).isEqualTo(2 * 3)
    }
}
