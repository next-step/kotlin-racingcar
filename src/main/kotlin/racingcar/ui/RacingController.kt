package racingcar.ui

import racingcar.application.RacingResponse
import racingcar.application.RacingService
import racingcar.application.WinnerResponse
import racingcar.domain.Car
import racingcar.domain.CarSelector
import racingcar.domain.Cars
import racingcar.domain.Winner

class RacingController(private val racingService: RacingService) {

    fun play(carNames: String, roundCount: String): RacingResponse {
        val readyCars = CarSelector(carNames).names
            .map { (Car(it)) }

        return racingService.start(roundCount.toInt(), Cars(readyCars))
    }

    fun winner(cars: List<Car>): WinnerResponse {
        return WinnerResponse(Winner(cars))
    }
}
