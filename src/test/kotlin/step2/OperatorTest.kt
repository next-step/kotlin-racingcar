package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @DisplayName("1) 사칙연산 기호가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["#", "^", "&", "@"])
    fun failed (operator: String){
        assertThatThrownBy { Operator.makeOperator(operator) }
            .isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("사용 불가능한 연산자입니다.")
    }

    @DisplayName("2) 사칙연산 기호가 맞는 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["+", "-","*", "/"])
    fun success (operator: String){
        val makeOperator = Operator.makeOperator(operator)
        assertThat(makeOperator.operator).isEqualTo(operator)
    }
}
