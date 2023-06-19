package racingcar.domain

import racingcar.domain.exception.NoWinnerException
import racingcar.dto.RaceWinner

class RaceResultEstimator {

    fun estimate(cars: List<Car>): RaceWinner {
        val winnerCar = findWinnerCar(cars)
        val winnerNameSet = findWinnerName(cars = cars, winnerCar = winnerCar)
        return RaceWinner(winnerNameSet = winnerNameSet)
    }

    private fun findWinnerCar(cars: List<Car>): Car {
        return cars.maxByOrNull { it.location } ?: throw NoWinnerException("경주 우승자가 없습니다. Car들을 확인하세요.")
    }

    private fun findWinnerName(cars: List<Car>, winnerCar: Car): Set<String> {
        return cars.filter { it.location == winnerCar.location }.map { it.name }.toSet()
    }
}
