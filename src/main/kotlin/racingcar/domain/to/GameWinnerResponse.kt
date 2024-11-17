package racingcar.domain.to

import racingcar.domain.Cars

class GameWinnerResponse(private val cars: Cars) {
    val to: List<String> = extractWinnersFromCars(cars)

    init {
        extractWinnersFromCars(cars)
    }

    private fun extractWinnersFromCars(cars: Cars): List<String> {
        return cars.getCarNames()
    }
}
