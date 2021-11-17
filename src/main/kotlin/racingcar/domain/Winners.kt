package racingcar.domain

object Winners {

    fun winnerNames(cars: List<Car>): List<String> {
        val maxPosition = maxPosition(cars)
        return searchRaceWinnerNames(cars, maxPosition)
    }

    private fun searchRaceWinnerNames(
        cars: List<Car>,
        maxPosition: Int,
    ) = cars.filter { it.isSameCarMaxPositionMessage(maxPosition) }.map {
        it.carName.name
    }

    private fun maxPosition(cars: List<Car>) = cars.maxOf {
        it.carPosition()
    }
}
