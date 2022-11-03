import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorKtTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `잘못된 인자`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { calculator(input) }
    }

    @Test
    fun `널 타입`() {
        assertThatIllegalArgumentException().isThrownBy { calculator(null) }
    }

    @Test
    fun `단일 숫자`() {
        assertThat(calculator("6")).isEqualTo(6)
    }

    @Test
    fun `덧셈`() {
        assertThat(calculator("6 + 3")).isEqualTo(9)
    }

    @Test
    fun `뺄셈`() {
        assertThat(calculator("6 - 2")).isEqualTo(4)
    }

    @Test
    fun `곱셈`() {
        assertThat(calculator("6 * 2")).isEqualTo(12)
    }

    @Test
    fun `나눗셈`() {
        assertThat(calculator("6 / 2")).isEqualTo(3)
    }

    @Test
    fun `계산식`() {
        assertThat(calculator("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @Test
    fun `계산식2`() {
        assertThat(calculator("5 - 1 / 4 * 2")).isEqualTo(2)
    }

    @Test
    fun `0으로 나누면 IllegalArgumentException`() {
        assertThat(calculator("5 - 1 / 4 * 0")).isEqualTo(0)
    }

    @Test
    fun `잘못된 연산기호`() {
        assertThatIllegalArgumentException().isThrownBy { calculator("5 - 1 / 4 % 2") }
    }

    @Test
    fun `잘못된 순서로 입력`() {
        assertThatIllegalArgumentException().isThrownBy { calculator("5 - 1 / * * 2") }
    }
}
