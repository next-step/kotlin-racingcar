package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullSource
import java.util.LinkedList
import java.util.stream.Stream

class StringCalculatorTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    fun `Parsing null or blank`(input: String?) {
        assertThatThrownBy {
            StringCalculator.parsing(
                stringExpression = input,
                result = {}
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Null or blank string expression")
    }

    @ParameterizedTest
    @MethodSource(value = ["provideExpression"])
    fun `Parsing expression`(string: String, number: List<Int>, expression: List<Operator>) {
        StringCalculator.parsing(
            stringExpression = string,
            result = {
                assertThat(it.first).isEqualTo(number)
                assertThat(it.second).isEqualTo(expression)
            }
        )
    }

    @ParameterizedTest
    @MethodSource(value = ["provideExpressionAndResult"])
    fun `StringCalculator - evaluate test`(number: List<Int>, expression: List<Operator>, result: Int) {
        StringCalculator.evaluate(LinkedList(number), LinkedList(expression)).also {
            assertThat(it).isEqualTo(result)
        }
    }

    companion object {
        @JvmStatic
        fun provideExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(" 23 + 3 * 4 / 2 ", listOf(23, 3, 4, 2), listOf(Operator.ADD, Operator.MUL, Operator.DIV)),
                Arguments.of("23+3*4/2", listOf(23, 3, 4, 2), listOf(Operator.ADD, Operator.MUL, Operator.DIV)),
                Arguments.of("23 +3 *4/ 2", listOf(23, 3, 4, 2), listOf(Operator.ADD, Operator.MUL, Operator.DIV)),
                Arguments.of(
                    "23     +    3   *4/  2",
                    listOf(23, 3, 4, 2),
                    listOf(Operator.ADD, Operator.MUL, Operator.DIV)
                )
            )
        }

        @JvmStatic
        fun provideExpressionAndResult(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(2, 3, 4, 2), listOf(Operator.ADD, Operator.ADD, Operator.ADD), 11),
                Arguments.of(listOf(1, 2, 3, 4, 5), listOf(Operator.MUL, Operator.MUL, Operator.MUL, Operator.MUL), 120)
            )
        }
    }
}
