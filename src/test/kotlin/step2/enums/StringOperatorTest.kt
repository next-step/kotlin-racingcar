package step2.enums

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringOperatorTest {
    @Test
    fun `StringOperator를 알맞게 변환한다`() {
        StringOperator.from("+") shouldBe StringOperator.PLUS
        StringOperator.from("-") shouldBe StringOperator.MINUS
        StringOperator.from("*") shouldBe StringOperator.MULTIPLY
        StringOperator.from("/") shouldBe StringOperator.DIVIDE
    }

    @ParameterizedTest
    @ValueSource(strings = ["&", "$"])
    fun `StringOperator가 아닌 경우 IllegalArgumentException throw`(symbol: String) {
        assertThrows<IllegalArgumentException> {
            StringOperator.from(symbol)
        }
    }
}
