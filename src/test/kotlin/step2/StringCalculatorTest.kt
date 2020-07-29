package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.util.LinkedList

class StringCalculatorTest {

    @Test
    fun `Parsing null or blank`() {
        assertThatThrownBy {
            StringCalculator.parsing(
                stringExpression = null,
                result = {}
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Null or blank string expression")

        assertThatThrownBy {
            StringCalculator.parsing(
                stringExpression = "   ",
                result = {}
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Null or blank string expression")
    }

    @Test
    fun `Parsing include regular spacing`() {
        StringCalculator.parsing(
            stringExpression = " 23 + 3 * 4 / 2 ",
            result = {
                assertThat(it.first).isEqualTo(listOf(23, 3, 4, 2))
                assertThat(it.second).isEqualTo(listOf(Operator.ADD, Operator.MUL, Operator.DIV))
            }
        )
    }

    @Test
    fun `Parsing exclude indentation`() {
        StringCalculator.parsing(
            stringExpression = "23+3*4/2",
            result = {
                assertThat(it.first).isEqualTo(listOf(23, 3, 4, 2))
                assertThat(it.second).isEqualTo(listOf(Operator.ADD, Operator.MUL, Operator.DIV))
            }
        )
    }

    @Test
    fun `Parsing include irregular spacing`() {
        StringCalculator.parsing(
            stringExpression = "23 +3 *4/ 2",
            result = {
                assertThat(it.first).isEqualTo(listOf(23, 3, 4, 2))
                assertThat(it.second).isEqualTo(listOf(Operator.ADD, Operator.MUL, Operator.DIV))
            }
        )

        StringCalculator.parsing(
            stringExpression = "23     +    3   *4/  2",
            result = {
                assertThat(it.first).isEqualTo(listOf(23, 3, 4, 2))
                assertThat(it.second).isEqualTo(listOf(Operator.ADD, Operator.MUL, Operator.DIV))
            }
        )
    }

    @Test
    fun `StringCalculator - evaluate test`() {
        StringCalculator.evaluate(
            LinkedList(listOf(2, 3, 4, 2)),
            LinkedList(listOf(Operator.ADD, Operator.ADD, Operator.ADD))
        ).also {
            assertThat(it).isEqualTo(11)
        }

        StringCalculator.evaluate(
            LinkedList(listOf(1, 2, 3, 4, 5)),
            LinkedList(listOf(Operator.MUL, Operator.MUL, Operator.MUL, Operator.MUL))
        ).also {
            assertThat(it).isEqualTo(120)
        }
    }
}
