package first_week_carrace

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 생성 테스트`() {
        val car = Car("test")
        assertThat(car.position).isEqualTo(1)
        assertThat(car.name).isEqualTo("test")
    }

    @Test
    fun `자동차 전진 테스트`() {
        val car = Car("test") { true }
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.position).isEqualTo(11)
    }

    @Test
    fun `자동차 정지 테스트`() {
        val car = Car("test") { false }
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.position).isEqualTo(1)
    }
}
