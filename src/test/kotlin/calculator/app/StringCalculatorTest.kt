package calculator.app

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
}
