package calculator.service

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal
import java.util.Collections.emptyList

internal class StringCalculatorProcessorTest {
    @Test
    internal fun `길이가 0인 리스트`() {
        val list = emptyList<String>()
        assertThatThrownBy { StringCalculatorProcessor(list).process() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "* 1 + 2", "1 + + 2", "1 +", "1 1 2", "1 $ 2"])
    internal fun `계산할 수 없는 리스트`(input: String) {
        val list = input.split(" ")
        assertThatThrownBy { StringCalculatorProcessor(list).process() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:10", "5 * 10 / 5 / 2:5", "7 / 2 * 100 - 1:299"], delimiter = ':')
    fun `계산할 수 있는 리스트`(input: String, expected: BigDecimal) {
        val list = input.split(" ")
        assertThat(StringCalculatorProcessor(list).process()).isEqualTo(expected)
    }
}
