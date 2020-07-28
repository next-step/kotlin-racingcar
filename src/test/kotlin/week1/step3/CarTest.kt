package week1.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `전진 조건이 아닐 경우`() {
        val car = Car().apply {
            setupForwardLimitCondition()
        }
        assertThat(car.forwardCount).isLessThan(4)
    }

    @Test
    fun `전진 조건인 경우`() {
        val car = Car().apply {
            setupForwardCondition()
        }
        assertThat(car.forwardCount).isGreaterThan(3)
    }
}
