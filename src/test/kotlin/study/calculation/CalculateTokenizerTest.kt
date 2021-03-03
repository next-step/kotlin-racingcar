package study.calculation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CalculateTokenizerTest {
    @Test
    fun `토큰 연산자 피연산자 갯수 테스트`() {
        val calculateTokenizer = CalculateTokenizer()
        val token = calculateTokenizer.tokenize("2 + 3 * 4 / 2")

        assertThat(token.operators.size).isEqualTo(3)
        assertThat(token.operands.size).isEqualTo(4)
    }

    @ParameterizedTest
    @ValueSource(strings = ["  ", "", "null", "2 2 3 + 4"])
    fun `토크나이즈 null 혹은 빈 문자열 잘못된 식 테스트`(input: String) {
        val calculateTokenizer = CalculateTokenizer()
        assertThrows<IllegalArgumentException> {
            calculateTokenizer.tokenize(if (input == "null") null else input)
        }
    }
}
