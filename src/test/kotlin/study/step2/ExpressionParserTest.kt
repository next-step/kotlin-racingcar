package study.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ExpressionParserTest {

    lateinit var sut: ExpressionParser

    @BeforeEach
    fun setUp() {
        sut = ExpressionParser()
    }

    @Test
    fun `number와 operator를 분리할 수 있다 - 1`() {
        val expression = "1 + 1"

        val (operands, operators) = sut.parse(expression)

        assertThat(operands).isEqualTo(listOf(1.0, 1.0))
        assertThat(operators).isEqualTo(listOf(Symbol.ADDITION))
    }

    @Test
    fun `number와 operator를 분리할 수 있다 - 2`() {
        val expression = "1 + 2 - 3 * 4 / 5"

        val (operands, operators) = sut.parse(expression)

        assertThat(operands).isEqualTo(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
        assertThat(operators).isEqualTo(
            listOf(
                Symbol.ADDITION, Symbol.SUBTRACTION, Symbol.MULTIPLICATION, Symbol.DIVISION
            )
        )
    }
}
