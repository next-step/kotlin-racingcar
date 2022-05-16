package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.Car
import racing.car.CarRegistration
import racing.common.CarRaceProperty

class CarRegistrationTest {

    @Test
    fun `자동차 초기 데이터(자동차 대수) 입력 테스트`() {
        val roundSize = 1
        val cars = listOf(Car(0), Car(0), Car(0))
        val carRaceProperty = CarRaceProperty(roundSize, cars.size, cars)

        val carRegistration = CarRegistration(roundSize, cars.size)
        carRegistration.initCarRaceProperty()

        assertThat(carRaceProperty.cars.size).isEqualTo(cars.size)
    }
}
