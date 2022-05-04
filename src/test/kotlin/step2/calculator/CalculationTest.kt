package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculationTest {
    @Test
    fun `Calculation 클래스가 프로퍼티를 제대로 보관하는가`() {
        val plusCalculation = Calculation(
            operator = Operator.PLUS,
            number = 100.0
        )
        val minusCalculation = Calculation(
            operator = Operator.MINUS,
            number = 5.0
        )

        assertThat(plusCalculation.operator).isEqualTo(Operator.PLUS)
        assertThat(plusCalculation.number).isEqualTo(100.0)
        assertThat(minusCalculation.operator).isEqualTo(Operator.MINUS)
        assertThat(minusCalculation.number).isEqualTo(5.0)
    }
}