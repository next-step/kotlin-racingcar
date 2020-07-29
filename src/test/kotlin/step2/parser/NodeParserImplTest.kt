package step2.parser

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import step2.calculator.Node

class NodeParserImplTest {
    @Test
    fun `parse() 예제 입력 테스트`() {
        assertThat(NodeParserImpl().parse("2 + 3 * 4 / 2"))
            .isEqualTo(
                listOf(
                    Node.Number(2.0),
                    Node.Operator.Plus,
                    Node.Number(3.0),
                    Node.Operator.Multiply,
                    Node.Number(4.0),
                    Node.Operator.Divide,
                    Node.Number(2.0)
                )
            )
    }

    @Test
    fun `parse() 다양한 입력 검증`() {
        assertThat(NodeParserImpl().parse("123456 +++   0 *- 4 4 444 // 2    "))
            .isEqualTo(
                listOf(
                    Node.Number(123456.0),
                    Node.Operator.Plus,
                    Node.Operator.Plus,
                    Node.Operator.Plus,
                    Node.Number(0.0),
                    Node.Operator.Multiply,
                    Node.Operator.Minus,
                    Node.Number(4.0),
                    Node.Number(4.0),
                    Node.Number(444.0),
                    Node.Operator.Divide,
                    Node.Operator.Divide,
                    Node.Number(2.0)
                )
            )
    }

    @Test
    fun `parse() 잘못된 입력이 있는 경우 InvalidCharacter 발생`() {
        assertThatThrownBy {
            assertThat(NodeParserImpl().parse("123 * 12 _ 3"))
        }.isInstanceOf(NodeParser.Error.InvalidCharacter::class.java)
            .hasMessage("Invalid character _ has found in text.")
    }

    @Test
    fun `trimAll() 각 리스트의 모든 문자열 trim 테스트`() {
        NodeParserImpl().apply {
            assertThat(listOf("hello ", "kotlin! ", " ", "world").trimAll())
                .isEqualTo(listOf("hello", "kotlin!", "", "world"))
        }
    }

    @Test
    fun `exceptEmpty() 공백 문자열은 리스트에서 제외 테스트`() {
        NodeParserImpl().apply {
            assertThat(listOf("", " ", "! ", "", "", "hello").exceptEmpty())
                .isEqualTo(listOf(" ", "! ", "hello"))
        }
    }

    @Test
    fun `convertToNode() 문자열을 Node로 변환`() {
        NodeParserImpl().apply {
            assertThat("123".convertToNode()).isEqualTo(Node.Number(123.0))
            assertThat("0".convertToNode()).isEqualTo(Node.Number(0.0))
            assertThat("123".convertToNode()).isEqualTo(Node.Number(123.0))
            assertThat("+".convertToNode()).isEqualTo(Node.Operator.Plus)
            assertThat("-".convertToNode()).isEqualTo(Node.Operator.Minus)
            assertThat("*".convertToNode()).isEqualTo(Node.Operator.Multiply)
            assertThat("/".convertToNode()).isEqualTo(Node.Operator.Divide)
        }
    }

    @Test
    fun `convertToNode() 잘못된 문자열 InvalidCharacter 반환`() {
        assertThatThrownBy {
            NodeParserImpl().apply {
                "XXX".convertToNode()
            }
        }.isInstanceOf(NodeParser.Error.InvalidCharacter::class.java)
            .hasMessage("Invalid character XXX has found in text.")

        assertThatThrownBy {
            NodeParserImpl().apply {
                "_".convertToNode()
            }
        }.isInstanceOf(NodeParser.Error.InvalidCharacter::class.java)
            .hasMessage("Invalid character _ has found in text.")
    }

    @Test
    fun `convertAllToNode() 문자열 리스트를 Node 리스트로 변환`() {
        NodeParserImpl().apply {
            assertThat(
                listOf("123", "0", "123", "+", "-", "*", "/").convertAllToNode()
            ).isEqualTo(
                listOf(
                    Node.Number(123.0),
                    Node.Number(0.0),
                    Node.Number(123.0),
                    Node.Operator.Plus,
                    Node.Operator.Minus,
                    Node.Operator.Multiply,
                    Node.Operator.Divide
                )
            )
        }
    }
}
