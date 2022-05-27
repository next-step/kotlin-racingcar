package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class EquationTokenizerTest {
    private val equationTokenizer = EquationTokenizer()

    @ParameterizedTest
    @MethodSource("tokenize")
    internal fun `토크나이징`(input: String, expectedOperands: List<Operand>, expectedOperators: List<Operator>) {
        val (operands, operators) = equationTokenizer.tokenize(input)

        assertThat(operands).containsExactlyInAnyOrderElementsOf(expectedOperands)
        assertThat(operators).containsExactlyInAnyOrderElementsOf(expectedOperators)
    }

    companion object {
        @JvmStatic
        fun tokenize(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1 + 2", mutableListOf(Operand("1"), Operand("2")), mutableListOf(Operator.PLUS)),
                Arguments.arguments(
                    "3 * 4 / 2",
                    mutableListOf(Operand("3"), Operand("4"), Operand("2")),
                    mutableListOf(Operator.MULTIPLY),
                    Operator.DIVIDE
                )
            )
        }
    }
}
