package racingcar.domain

object Winners {

    fun winnerNames(cars: List<Car>): String {
        val maxPosition = maxPosition(cars)
        return searchRaceWinnerNames(cars, maxPosition)
    }

    private fun searchRaceWinnerNames(
        cars: List<Car>,
        maxPosition: Int,
    ) = cars.filter { it.carPosition() == maxPosition }.joinToString {
        it.carName.name
    }

    private fun maxPosition(cars: List<Car>) = cars.maxOf {
        it.carPosition()
    }
}
