package racingcar.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @ParameterizedTest
    @CsvSource(
        "+, PLUS",
        "-, MINUS",
        "*, MULTIPLE",
        "/, DIVIDE",
    )
    fun `문자열에 맞는 enum 을 생성`(
        symbol: String,
        expectedOperator: Operator,
    ) {
        assertThat(Operator.getOperatorBySymbol(symbol)).isEqualTo(expectedOperator)
    }

    @Test
    fun `문자열에 맞는 enum 생성 후 연산 `() {
        val operator = Operator.getOperatorBySymbol("+")
        assertThat(operator.apply(1.0, 2.0)).isEqualTo(3.0)
    }
}
