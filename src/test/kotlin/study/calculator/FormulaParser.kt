package study.calculator

import calculator.FormulaParser
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class FormulaParser {

    companion object {
        @JvmStatic
        fun calculateErrorTestData() = listOf(
            arrayOf("2 + 3 * 4 / 2 *", IllegalArgumentException()),
            arrayOf("4 - 1 + 3 * +", NumberFormatException()),
            arrayOf("19 * 2 + 18 ) 20", IllegalArgumentException()),
            arrayOf("      ", IllegalArgumentException()),
            arrayOf("19 * 2 + 18 / 0", IllegalArgumentException()),
        )
    }

    @ParameterizedTest
    @MethodSource("calculateErrorTestData")
    fun `, 잘못된 수식을 calculate()에 넣어 호출하면, 에러를 배출한다`(formula: String, expected: Exception) {
        // when : 잘못된 수식을 calculator.FormulaParser().parse(formula)에 넣어 호출한다.
        val actual = runCatching { FormulaParser.parse(formula) }.exceptionOrNull()

        // then : 에러를 배출한다.
        Assertions.assertThat(actual).isInstanceOf(expected::class.java)
    }
}
