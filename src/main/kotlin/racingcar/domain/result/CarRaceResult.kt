package racingcar.domain.result

import racingcar.domain.car.Car

class CarRaceResult(val carRaceResults: List<CarRaceResultForRound>) {
    fun findWinners(): List<CarSnapShot> {
        return carRaceResults.last().getWinnersForRound()
    }
}

class CarRaceResultForRound(cars: List<Car>) {
    val carSnapShots = cars.map { CarSnapShot(it) }

    internal fun getWinnersForRound(): List<CarSnapShot> {
        val maxPosition = carSnapShots.map { it.position }
            .maxOf { it }

        return carSnapShots.filter { it.isSamePositionWith(maxPosition) }
    }
}

class CarSnapShot(car: Car) {
    val name = car.name.value
    val position = car.position.value

    internal fun isSamePositionWith(maxPosition: Int): Boolean {
        return position == maxPosition
    }
}
