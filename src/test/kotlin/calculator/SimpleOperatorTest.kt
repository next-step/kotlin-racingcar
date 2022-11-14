package operator

import calculator.SimpleOperator
import calculator.enums.ExceptionCode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SimpleOperatorTest {

    private val operator = SimpleOperator()
    @Test
    @DisplayName("더하기 단항 연산을 성공한다")
    fun singlePlusSuccess() {
        Assertions.assertThat(operator.add(1F, 2F)).isEqualTo(3F)
        Assertions.assertThat(operator.add(10F, 20F)).isEqualTo(30F)
        Assertions.assertThat(operator.add(0F, 2F)).isEqualTo(2F)
    }

    @Test
    @DisplayName("빼기 단항 연산을 성공한다")
    fun singleMinusSuccess() {
        Assertions.assertThat(operator.minus(1F, 2F)).isEqualTo(-1F)
        Assertions.assertThat(operator.minus(10F, 20F)).isEqualTo(-10F)
        Assertions.assertThat(operator.minus(0F, 2F)).isEqualTo(-2F)
    }

    @Test
    @DisplayName("곱하기 단항 연산을 성공한다")
    fun singleMultipleSuccess() {
        Assertions.assertThat(operator.multiple(1F, 2F)).isEqualTo(2F)
        Assertions.assertThat(operator.multiple(10F, 20F)).isEqualTo(200F)
        Assertions.assertThat(operator.multiple(0F, 2F)).isEqualTo(0F)
    }

    @Test
    @DisplayName("나누기 단항 연산을 성공한다")
    fun singleDivideSuccess() {
        Assertions.assertThat(operator.divide(1F, 2F)).isEqualTo(0.5F)
        Assertions.assertThat(operator.divide(10F, 20F)).isEqualTo(0.5F)
        Assertions.assertThat(operator.divide(0F, 2F)).isEqualTo(0F)
    }

    @Test
    @DisplayName("0으로 나누면 divide zero에러를 냅니다")
    fun notAllowedDivideZero() {

        Assertions.assertThatThrownBy {
            operator.divide(0F, 0F)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())

        Assertions.assertThatThrownBy {
            operator.divide(1F, 0F)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())

        Assertions.assertThatThrownBy {
            operator.divide(-1F, 0F)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_DIVIDE_ZERO.getMessage())
    }
}
