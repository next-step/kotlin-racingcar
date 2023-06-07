package step2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.execute(null)
        }

        assertThrows<IllegalArgumentException> {
            stringCalculator.execute("")
        }

        assertThrows<IllegalArgumentException> {
            stringCalculator.execute(" ")
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.execute("1 & 2")
        }

        assertThrows<IllegalArgumentException> {
            stringCalculator.execute("1 + 2 @ 3")
        }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 기능 구현`() {
        stringCalculator.execute("2 + 3 * 4 / 2") shouldBe 10

        stringCalculator.execute("2 + 3 * 4 / 2 - 5") shouldBe 5
    }
}
