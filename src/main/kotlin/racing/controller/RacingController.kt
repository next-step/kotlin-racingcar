package racing.controller

import racing.controller.dto.ResultView
import racing.domain.Car
import racing.service.CarService

class RacingController(private val carService: CarService) {

    fun playGame(users: List<String>, round: Int): ResultView {
        require(users.isNotEmpty() && round >= 1) {
            "자동차, 라운드 수를 정확히 입력해주세요"
        }
        val cars = users.map { Car(it) }.toList()

        return carService.moveCars(cars, round)
    }
}
