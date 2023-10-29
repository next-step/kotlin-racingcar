package week1.calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTypeTest {

    @Test
    fun `더하기`() {
        Assertions.assertThat(OperatorType.ADD.execute(1, 2)).isEqualTo(3)
        Assertions.assertThat(OperatorType.ADD.execute(123000, 456)).isEqualTo(123456)
    }

    @Test
    fun `빼기`() {
        Assertions.assertThat(OperatorType.SUBTRACT.execute(1, 2)).isEqualTo(-1)
        Assertions.assertThat(OperatorType.SUBTRACT.execute(10, 2)).isEqualTo(8)
    }

    @Test
    fun `곱하기`() {
        Assertions.assertThat(OperatorType.MULTIPLY.execute(1, 2)).isEqualTo(2)
        Assertions.assertThat(OperatorType.MULTIPLY.execute(123, 456)).isEqualTo(56088)
    }

    @Test
    fun `나누기`() {
        Assertions.assertThat(OperatorType.DIVIDE.execute(1, 2)).isEqualTo(0)
        Assertions.assertThat(OperatorType.DIVIDE.execute(100, 9)).isEqualTo(11)
        Assertions.assertThat(OperatorType.DIVIDE.execute(100, 0)).isEqualTo(100)
    }

    @ParameterizedTest
    @EnumSource(OperatorType::class)
    fun `연산자 검증`(operatorType: OperatorType) {
        Assertions.assertThatCode {
            OperatorType.from(operatorType.value)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["_", "@", "#", "+-", "++"])
    fun `유효하지 않은 연산자`(invalidOperator: String) {
        Assertions.assertThat(OperatorType.isOperatorSymbol(invalidOperator)).isFalse()
    }
}