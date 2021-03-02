package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
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
}
