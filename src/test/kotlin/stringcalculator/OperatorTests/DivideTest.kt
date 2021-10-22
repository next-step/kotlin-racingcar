package stringcalculator.OperatorTests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringcalculator.Operational
import stringcalculator.Operator

class DivideTest {
    @ParameterizedTest
    @CsvSource(*["2, 1", "1, 2"])
    fun `execute 시 두 값을 나눈 결과를 리턴한다`(left: Int, right: Int) {
        val operational = Operational(left, right)

        val result = Operator.DIVIDE.execute(operational)

        assertThat(result).isEqualTo(left / right)
    }

    @Test
    fun `0으로 나누는 경우 ArithmeticException 에러를 일으킨다`() {
        val operational = Operational(2, 0)

        assertThrows<ArithmeticException> {
            Operator.DIVIDE.execute(operational)
        }
    }
}
