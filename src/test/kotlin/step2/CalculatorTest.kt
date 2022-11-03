package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.ThrowableAssert.ThrowingCallable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `수식이 널이면 예외를 발생시킨다`() {
        // given
        val throwingCallable = ThrowingCallable {
            calculator.calculate(null)
        }
        // then
        assertThatIllegalArgumentException().isThrownBy(throwingCallable).withMessage("expression is null or blank")
    }

    @Test
    fun `수식이 비어있으면 예외를 발생시킨다`() {
        // given
        val throwingCallable = ThrowingCallable {
            calculator.calculate("")
        }
        // then
        assertThatIllegalArgumentException().isThrownBy(throwingCallable).withMessage("expression is null or blank")
    }

    @Test
    fun `수식이 완성되지 않았다면 예외를 발생시킨다`() {
        // given
        val throwingCallable = ThrowingCallable {
            calculator.calculate("1 + 2 -")
        }
        // then
        assertThatIllegalArgumentException().isThrownBy(throwingCallable).withMessage("expression is not completed")
    }

    @Test
    fun `수식을 계산한 값을 반환한다`() {
        // when
        val actual = calculator.calculate("1 + 2 - 5")
        // then
        assertThat(actual).isEqualTo(-2)
    }
}
