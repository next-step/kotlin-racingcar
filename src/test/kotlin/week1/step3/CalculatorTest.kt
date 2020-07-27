package week1.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `전진 조건이 아닐 경우`() {
        val car = Car()
        car.updateForwardCount()
        assertThat(car.forwardCount).isLessThan(4)
    }
}
