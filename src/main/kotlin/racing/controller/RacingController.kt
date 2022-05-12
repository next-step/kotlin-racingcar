package racing.controller

import racing.controller.dto.RoundResultView
import racing.domain.Car
import racing.service.CarService

class RacingController(private val carService: CarService) {

    fun playGame(carNum: Int, round: Int): List<RoundResultView> {
        require(carNum >= 1 && round >= 1) {
            "자동차, 라운드 수를 정확히 입력해주세요"
        }
        val cars: List<Car> = List(carNum) { Car(0) }

        return carService.moveCars(cars, round)
    }
}
