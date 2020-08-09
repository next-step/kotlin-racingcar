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

    @Test
    fun `trimAll() 각 리스트의 모든 문자열 trim 테스트`() {
        NodeParser().apply {
            assertThat(listOf("hello ", "kotlin! ", " ", "world").trimAll())
                .isEqualTo(listOf("hello", "kotlin!", "", "world"))
        }
    }

    @Test
    fun `exceptEmpty() 공백 문자열은 리스트에서 제외 테스트`() {
        NodeParser().apply {
            assertThat(listOf("", " ", "! ", "", "", "hello").exceptEmpty())
                .isEqualTo(listOf(" ", "! ", "hello"))
        }
    }

    @Test
    fun `convertToNode() 문자열을 Node로 변환`() {
        NodeParser().apply {
            assertThat("123".convertToNode()).isEqualTo(Number(123.0))
            assertThat("0".convertToNode()).isEqualTo(Number(0.0))
            assertThat("123".convertToNode()).isEqualTo(Number(123.0))
            assertThat("+".convertToNode()).isEqualTo(Operator.PLUS)
            assertThat("-".convertToNode()).isEqualTo(Operator.MINUS)
            assertThat("*".convertToNode()).isEqualTo(Operator.MULTIPLY)
            assertThat("/".convertToNode()).isEqualTo(Operator.DIVIDE)
        }
    }

    @Test
    fun `convertToNode() 잘못된 문자열 InvalidCharacter 반환`() {
        assertThatThrownBy {
            NodeParser().apply {
                "XXX".convertToNode()
            }
        }.isInstanceOf(Operator.InvalidCharacter::class.java)
            .hasMessage("Invalid character XXX has found in text.")

        assertThatThrownBy {
            NodeParser().apply {
                "_".convertToNode()
            }
        }.isInstanceOf(Operator.InvalidCharacter::class.java)
            .hasMessage("Invalid character _ has found in text.")
    }

    @Test
    fun `convertAllToNode() 문자열 리스트를 Node 리스트로 변환`() {
        NodeParser().apply {
            assertThat(
                listOf("123", "0", "123", "+", "-", "*", "/").convertAllToNode()
            ).isEqualTo(
                listOf(
                    Number(123.0),
                    Number(0.0),
                    Number(123.0),
                    Operator.PLUS,
                    Operator.MINUS,
                    Operator.MULTIPLY,
                    Operator.DIVIDE
                )
            )
        }
    }
}
