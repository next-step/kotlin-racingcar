package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.car.CarService
import step3.common.CarRaceProperty

class CarServiceTest {

    @Test
    fun `자동차 초기 데이터(자동차 대수) 입력 테스트`() {
        val carRaceProperty = CarRaceProperty()
        carRaceProperty.carSize = 5
        val carService = CarService(carRaceProperty)
        carService.initCars()

        assertThat(carRaceProperty.cars.size).isEqualTo(carRaceProperty.carSize)
    }
}
