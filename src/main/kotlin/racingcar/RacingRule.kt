package racingcar

object RacingRule {

    fun findWinners(cars: Cars): List<Car> {
        val maxPosition = cars.cars.maxBy { it.position }.position
        return cars.cars.filter { it.position == maxPosition }
    }
}
