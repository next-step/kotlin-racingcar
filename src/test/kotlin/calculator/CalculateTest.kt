package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("계산 기능 단위 테스트")
class CalculateTest {

    @Test
    fun `덧셈 테스트`() {
        val actual = add(2, 7)
        assertThat(actual).isEqualTo(9)
    }

    @Test
    fun `뺄셈 테스트`() {
        val actual = subtract(7, 2)
        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `곱셈 테스트`() {
        val actual = multiply(7, 2)
        assertThat(actual).isEqualTo(14)
    }

    @Test
    fun `나눗셈 테스트`() {
        val actual = divide(7, 2)
        assertThat(actual).isEqualTo(3)
    }
}
