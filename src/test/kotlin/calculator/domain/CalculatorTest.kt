package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.util.Lists
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {

    @DisplayName("계산할 수 없는 수식일때 에러 반환")
    @Test
    fun `계산할 수없는 수식일떄 에러반환`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Calculator(Lists.newArrayList("1", "+")) }
    }

    @DisplayName("연산자와 피연산자의 올바른 순서가 아니면 에러 반환")
    @Test
    fun `연산자와 피연산자의 순서가 올바르지 않을때 에러를 반환`() {
        assertThatIllegalArgumentException()
            .isThrownBy { Calculator(Lists.newArrayList("+", "1")) }
    }

    @DisplayName("올바른 순서와 수식일때는 정상 반환")
    @Test
    fun `올바른 순서와 수식일때는 정상 반환`() {
        assertThat(Calculator(Lists.newArrayList("1", "+", "1")).execute()).isEqualTo(2.0)
    }
}
