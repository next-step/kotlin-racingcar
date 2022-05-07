package step3.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `proceed를 통해 Car의 proceedLevel을 높일 수 있다`() {
        val car = Car()
        car.proceed()
        assertThat(car.proceedLevel).isEqualTo(1)
    }
}