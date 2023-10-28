package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class CalculatorTest {

    @Test
    fun `덧셈 테스트`() {
        assertThat(Calculator().calculate(1, "+", 3)).isEqualTo(4)
    }

    @Test
    fun `뺄셈 테스트`() {
        assertThat(Calculator().calculate(1, "-", 3)).isEqualTo(-2)
    }

    @Test
    fun `곱셈 테스트`() {
        assertThat(Calculator().calculate(1, "*", 3)).isEqualTo(3)
    }

    @Test
    fun `나눗셈 테스트`() {
        assertThat(Calculator().calculate(1, "/", 3)).isEqualTo(0)
    }

    @Test
    fun `미지원 연산자 테스트`() {
        assertThatThrownBy { Calculator().calculate(3, "%", 7) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid operator : %")
    }
}
