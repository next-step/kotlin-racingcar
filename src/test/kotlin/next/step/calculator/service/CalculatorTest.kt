package next.step.calculator.service

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `주어진 수식을 계산하여 반환`() {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }
}
