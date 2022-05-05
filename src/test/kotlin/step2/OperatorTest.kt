package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {

    @ParameterizedTest
    @CsvSource(
        value = ["1, 2"],
        delimiter = ','
    )
    fun `ADDITION Operator 테스트`(first: Int, second: Int) {
        val operator = Operator.ADDITION
        Assertions.assertThat(operator.operate(first, second)).isEqualTo(3)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["15, 5"],
        delimiter = ','
    )
    fun `SUBTRACTION Operator 테스트`(first: Int, second: Int) {
        val operator = Operator.SUBTRACTION
        Assertions.assertThat(operator.operate(first, second)).isEqualTo(10)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["3, 5"],
        delimiter = ','
    )
    fun `MULTIPLICATION Operator 테스트`(first: Int, second: Int) {
        val operator = Operator.MULTIPLICATION
        Assertions.assertThat(operator.operate(first, second)).isEqualTo(15)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["50, 5"],
        delimiter = ','
    )
    fun `DIVISION Operator 테스트`(first: Int, second: Int) {
        val operator = Operator.DIVISION
        Assertions.assertThat(operator.operate(first, second)).isEqualTo(10)
    }
}
