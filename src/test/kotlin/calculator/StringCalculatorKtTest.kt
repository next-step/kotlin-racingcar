package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

internal class StringCalculatorKtTest {

    private lateinit var stringCalculator: StringCalculator

    @BeforeEach
    fun setUp() {
        stringCalculator = StringCalculator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `잘못된 인자`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculator(input) }
    }

    @Test
    fun `널 타입`() {
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculator(null) }
    }

    @Test
    fun `단일 숫자`() {
        assertThat(stringCalculator.calculator("6")).isEqualTo(BigDecimal(6))
    }

    @Test
    fun `덧셈`() {
        assertThat(stringCalculator.calculator("6 + 3")).isEqualTo(BigDecimal(9))
    }

    @Test
    fun `뺄셈`() {
        assertThat(stringCalculator.calculator("6 - 2")).isEqualTo(BigDecimal(4))
    }

    @Test
    fun `곱셈`() {
        assertThat(stringCalculator.calculator("6 * 2")).isEqualTo(BigDecimal(12))
    }

    @Test
    fun `나눗셈`() {
        assertAll(
            { assertThat(stringCalculator.calculator("6 / 2")).isEqualTo(BigDecimal(3)) },
            { assertThat(stringCalculator.calculator("6 / 4")).isEqualTo(BigDecimal(1.5)) }
        )
    }

    @Test
    fun `계산식`() {
        assertThat(stringCalculator.calculator("2 + 3 * 4 / 2")).isEqualTo(BigDecimal(10))
    }

    @Test
    fun `계산식2`() {
        assertThat(stringCalculator.calculator("5 - 1 / 4 * 2")).isEqualTo(BigDecimal(2))
    }

    @Test
    fun `0으로 나누면 IllegalArgumentException`() {
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculator("5 - 1 / 0") }
    }

    @Test
    fun `잘못된 연산기호 입력하면, IllegalArgumentException`() {
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculator("5 - 1 / 4 % 2") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["+ 5 - 1 / * 2", "5 - 1 / * * 2", "s 5 - 2 / 3"])
    fun `잘못된 순서로 입력하면, IllegalArgumentException`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculator(input) }
    }
}
