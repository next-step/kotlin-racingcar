package calculator.parser

import calculator.calculator.Number
import calculator.calculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NodeParserTest {
    @Test
    fun `parse() 예제 입력 테스트`() {
        assertThat(NodeParser().parse("2 + 3 * 4 / 2"))
            .isEqualTo(
                listOf(
                    Number(2.0),
                    Operator.PLUS,
                    Number(3.0),
                    Operator.MULTIPLY,
                    Number(4.0),
                    Operator.DIVIDE,
                    Number(2.0)
                )
            )
    }

    @Test
    fun `parse() 다양한 입력 검증`() {
        assertThat(NodeParser().parse("123456 +++   0 *- 4 4 444 // 2    "))
            .isEqualTo(
                listOf(
                    Number(123456.0),
                    Operator.PLUS,
                    Operator.PLUS,
                    Operator.PLUS,
                    Number(0.0),
                    Operator.MULTIPLY,
                    Operator.MINUS,
                    Number(4.0),
                    Number(4.0),
                    Number(444.0),
                    Operator.DIVIDE,
                    Operator.DIVIDE,
                    Number(2.0)
                )
            )
    }

    @Test
    fun `parse() 잘못된 입력이 있는 경우 InvalidCharacter 발생`() {
        assertThatThrownBy {
            assertThat(NodeParser().parse("123 * 12 _ 3"))
        }.isInstanceOf(Operator.InvalidCharacter::class.java)
            .hasMessage("Invalid character _ has found in text.")
    }
}
