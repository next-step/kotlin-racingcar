package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarFactoryTest {
    private val sut = CarFactory
    @Test
    fun `id 가 중복되지 않은 차량을 생성할 수 있다`() {
        // given

        // when
        val tCar1 = sut.newCar()
        val tCar2 = sut.newCar()

        // then
        assertThat(tCar1.carId).isNotEqualTo(tCar2.carId)
    }
}
