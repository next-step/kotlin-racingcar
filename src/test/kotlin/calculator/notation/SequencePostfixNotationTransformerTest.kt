package calculator.notation

import calculator.Number
import calculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SequencePostfixNotationTransformerTest {

    @Test
    fun `중위 표현식을 후위 표현식으로 변경`() {
        val transformer = SequencePostfixNotationTransformer()

        val result = transformer.transform("5 - 3 + 2 / 2 * 3")
        val expected = listOf(
            Number.of("5"),
            Number.of("3"),
            Operator.MINUS,
            Number.of("2"),
            Operator.PLUS,
            Number.of("2"),
            Operator.DIVIDE,
            Number.of("3"),
            Operator.TIMES
        )

        assertThat(result).isEqualTo(expected)
    }
}
