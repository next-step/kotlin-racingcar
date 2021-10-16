package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    @ParameterizedTest
    @MethodSource
    fun evaluate(arg: CalculatorArg) {
        assertThat(Calculator.evaluate(arg.expression)).isEqualTo(arg.result)
    }

    @Suppress("unused")
    private fun evaluate(): List<CalculatorArg> {
        return listOf(
            CalculatorArg("2 + 3 * 4 / 2", 10.0),
            CalculatorArg("2 * 3 + 4 / 2", 5.0),
            CalculatorArg("2 + 3 + 4 / 2", 4.5),
            CalculatorArg("2 - 3 * 4 / 2", -2.0)
        )
    }

    data class CalculatorArg(
        val expression: String,
        val result: Double
    )
}
