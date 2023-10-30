package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class StringParserTest {
    @Test
    fun `계산식이 두개 이상이라면 계산식을 분리합니다 1`() {
        val input: String = "1 + 2 - 3"

        val result: List<Map<String, Any?>> = StringParser.parse(input)

        val firstParse = result[0]
        val secondParse = result[1]

        val firstExpectedParse: Map<String, Any?> = mapOf("left" to "1", "operator" to Operator.PLUS, "right" to "2")
        val secondExpectedParse: Map<String, Any?> = mapOf("left" to null, "operator" to Operator.MINUS, "right" to "3")

        assertAll(
            { assertThat(firstParse).isEqualTo(firstExpectedParse) },
            { assertThat(secondParse).isEqualTo(secondExpectedParse) }
        )
    }

    @Test
    fun `계산식이 두개 이상이라면 계산식을 분리합니다 2`() {
        val input: String = "1 + 2 - 3 * 4"

        val result: List<Map<String, Any?>> = StringParser.parse(input)

        val firstParse = result[0]
        val secondParse = result[1]
        val thirdParse = result[2]

        val firstExpectedParse: Map<String, Any?> = mapOf("left" to "1", "operator" to Operator.PLUS, "right" to "2")
        val secondExpectedParse: Map<String, Any?> = mapOf("left" to null, "operator" to Operator.MINUS, "right" to "3")
        val thirdExpectedParse: Map<String, Any?> = mapOf("left" to null, "operator" to Operator.MULTIPLY, "right" to "4")

        assertAll(
            { assertThat(firstParse).isEqualTo(firstExpectedParse) },
            { assertThat(secondParse).isEqualTo(secondExpectedParse) },
            { assertThat(thirdParse).isEqualTo(thirdExpectedParse) }
        )
    }
}
