package calculator

import calculator.notation.SequencePostfixNotationTransformer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator()
    private val notationTransformer: NotationTransformer = SequencePostfixNotationTransformer()

    @Test
    fun `5 - 3 + 2 나누기 2 * 3 = 6 이다`() {
        val words = notationTransformer.transform("5 - 3 + 2 / 2 * 3")
        val result = calculator.calculate(words)
        assertThat(result).isEqualTo(Number.of("6"))
    }
}
