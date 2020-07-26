package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `넣은 자동차 개수만큼 자동차 거리 List개수를 반환하는지 확인`() {
        // given
        val car = Car(CarMover())
        val carList = listOf(car, car, car, car)
        val cars = Cars(carList)

        // then
        assertThat(cars.getCarDistances()).isEqualTo(4)
    }
}
