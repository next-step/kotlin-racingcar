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
    fun `사칙연산의 연산자 우선순위를 적용하지 않고 입력받은 순서대로 계산한다`() {
    }

    @Test
    fun `덧셈 기능이 동작 해야 한다`() {
    }

    @Test
    fun `뻴셈 기능이 동작 해야 한다`() {
    }

    @Test
    fun `곱셈 기능이 동작 해야 한다`() {
    }

    @Test
    fun `나눗셈 기능이 동작 해야 한다`() {
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
