package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @Test
    fun `자동차 생성 테스트`() {
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `자동차 전진 테스트`() {
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.getPosition()).isBetween(0, 10)
    }
}
