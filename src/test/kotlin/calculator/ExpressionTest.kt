package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ExpressionTest {

    @ParameterizedTest
    @MethodSource("generate")
    fun `계산하기`(operands: MutableList<Int>, operators: MutableList<String>, actual: Int) {

        val expected = Expression.calculate(operands, operators)

        assertThat(expected).isEqualTo(actual)
    }

    @ParameterizedTest
    @MethodSource("failGenerate")
    fun `연산자가 아닌 다른 문자열`(operands: MutableList<Int>, operators: MutableList<String>, actual: Int) {

        assertThrows<IllegalArgumentException> { Expression.calculate(operands, operators) }
    }

    @ParameterizedTest
    @MethodSource("failGenerateWithEmpty")
    fun `연산자가 더 많을 때`(operands: MutableList<Int>, operators: MutableList<String>, actual: Int) {
        assertThrows<NoSuchElementException> { Expression.calculate(operands, operators) }
    }

    companion object {
        @JvmStatic
        fun generate(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(mutableListOf(2, 3, 4, 2), mutableListOf("+", "*", "/"), 10),
                Arguments.of(mutableListOf(2, 1), mutableListOf("+"), 3)
            )
        }

        @JvmStatic
        fun failGenerate(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(mutableListOf(2, 3), mutableListOf("a"), 10)
            )
        }

        @JvmStatic
        fun failGenerateWithEmpty(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(mutableListOf(2), mutableListOf("+", "/"), 10)
            )
        }
    }
}
