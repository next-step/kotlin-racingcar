package study.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    companion object {
        @JvmStatic
        fun calculateTestData() = listOf(
            arrayOf("2 + 3 * 4 / 2", 10),
            arrayOf("4 - 1 + 3 * 2", 12),
            arrayOf("19 * 2 + 18 - 20", 36)
        )

        @JvmStatic
        fun calculateErrorTestData() = listOf(
            arrayOf("2 + 3 * 4 / 2 *", IllegalArgumentException()),
            arrayOf("4 - 1 + 3 * +", NumberFormatException()),
            arrayOf("19 * 2 + 18 ) 20", IllegalArgumentException()),
            arrayOf("      ", IllegalArgumentException())
        )
    }

    @ParameterizedTest
    @MethodSource("calculateTestData")
    fun `Calculator()를 생성하고, 올바른 수식을 calculate()에 넣어 호출하면, 올바른 결과값이 나온다`(formula: String, expected: Int) {
        // given : Calculator()를 생성한다.
        val calculator = Calculator()

        // when : 올바른 수식을 calculate()에 넣어 호출한다.
        val actual = calculator.calculate(formula)

        // then : 올바른 결과값이 나온다.
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("calculateErrorTestData")
    fun `Calculator()를 생성하고, 잘못된 수식을 calculate()에 넣어 호출하면, 에러를 배출한다`(formula: String, expected: Exception) {
        // given : Calculator()를 생성한다.
        val calculator = Calculator()

        // when : 잘못된 수식을 calculate()에 넣어 호출한다.
        val formulaComponent = formula.split(" ")
        val actual = runCatching { calculator.checkFormula(formulaComponent) }.exceptionOrNull()

        // then : 에러를 배출한다.
        assertThat(actual).isInstanceOf(expected::class.java)
    }
}
