package racingcarWinner.domain

class Winner(
    private val cars: List<Car>
) {
    fun getWinner(): List<String> =
        cars.filter { car -> car.isSameDistance(getMaxMoveStep()) }.map { it.carName }

    private fun getMaxMoveStep(): Int =
        cars.maxOf { it.moveStep }
}
