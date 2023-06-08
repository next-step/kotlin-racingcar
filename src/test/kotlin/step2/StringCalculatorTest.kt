package step2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    fun `입력값이 null인 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.execute(null)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우 IllegalArgumentException throw`(givenText: String) {
        assertThrows<IllegalArgumentException> {
            stringCalculator.execute(givenText)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 & 2", "1 + 2 @ 3"])
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(givenText: String) {
        assertThrows<IllegalArgumentException> {
            stringCalculator.execute(givenText)
        }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        stringCalculator.execute("2 + 3 * 4 / 2") shouldBe 10

        stringCalculator.execute("2 + 3 * 4 / 2 - 5") shouldBe 5
    }
}
