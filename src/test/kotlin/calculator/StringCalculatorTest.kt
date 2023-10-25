package calculator

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    private var calculator = StringCalculator()

    @BeforeEach
    fun beforeEach() {
        calculator = StringCalculator()
    }

    @Test
    fun `입력이 null 이면 IllegalArgumentException throw`() {
    }

    @Test
    fun `입력이 공백 문자열이면 IllegalArgumentException throw`() {
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
    }
}
