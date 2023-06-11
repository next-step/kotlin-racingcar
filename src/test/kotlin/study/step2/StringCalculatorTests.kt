package study.step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {

    private val tokenizer = Tokenizer(TokenListValidator())
    private val sut = StringCalculator(ExpressionFactory(tokenizer))

    @Test
    fun `입력값 받은 식을 계산한 결과를 반환한다`() {
        assertEquals(2, sut.calculate("1 + 2 * 3 / 4"))
    }
}
