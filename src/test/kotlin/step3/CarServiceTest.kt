package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.car.CarService

class CarServiceTest {

    @Test
    fun `자동차 초기 데이터(자동차 대수) 입력 테스트`() {
        CarRaceConst.carSize = 5
        val carService = CarService()
        carService.initCars()

        assertThat(CarRaceConst.car.size).isEqualTo(CarRaceConst.carSize)
    }
}
