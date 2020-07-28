package week1.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `전진 조건이 아닐 경우`() {
        val car = Car()
        car.updateForwardCount()
        assertThat(car.forwardCount).isLessThan(4)
    }

    @Test
    fun `전진 조건인 경우`() {
        val car = Car()
        for (i in 0..10) {
            car.updateForwardCount()
        }
        assertThat(car.forwardCount).isGreaterThan(3)
    }
}
