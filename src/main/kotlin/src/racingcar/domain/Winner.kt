package src.racingcar.domain

class Winner(
    private val racingCars: List<Car>
) {
    fun findWinners(): List<Car> {
        val max = racingCars.maxOf { it.moveCount }
        return racingCars.filter { car -> car.moveCount >= max }
    }
}
