package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OperatorTest {
    @ParameterizedTest
    @CsvSource("+,PLUS", "-,MINUS", "*,MULTIPLIED", "/,DIVIDED")
    fun `연산 기호 문자가 올바르게 enum에 매핑 됨`(operatorSymbol: String, operator: Operator) {
        assertThat(Operator.getBy(operatorSymbol)).isEqualTo(operator)
    }
}
