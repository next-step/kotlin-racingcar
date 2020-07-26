package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculateTypeTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun is_valid_symbol(input: String) {
        assertThat(CalculateType.find(input)).isNotEqualTo(null)
    }

    @ParameterizedTest
    @ValueSource(strings = ["=", ">", "<"])
    fun is_not_valid_symbol1(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                assertThat(CalculateType.find(input)).isEqualTo(null)
            }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun is_not_valid_symbol2(input: String) {
        val stringCalculator = StringCalculator()
        assertTrue(stringCalculator.isNotValidTypeSymbol(input))
    }

    @Test
    fun is_valid_calc_add() {
        assertThat(CalculateType.ADD.calc(3, 5)).isEqualTo(8)
    }

    @Test
    fun is_valid_calc_minus() {
        assertThat(CalculateType.MINUS.calc(3, 5)).isEqualTo(-2)
    }

    @Test
    fun is_valid_calc_divide() {
        assertThat(CalculateType.DIVIDE.calc(10, 2)).isEqualTo(5)
    }

    @Test
    fun is_valid_calc_multiply() {
        assertThat(CalculateType.MULTIPLY.calc(3, 5)).isEqualTo(15)
    }
}
