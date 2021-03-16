package racingcar.domain

import racingcar.history.RacingResultHistory

class CarCollection(userNames: List<String>) {

    private val cars: List<Car> = userNames.map { Car(it) }
    private val racingResultHistory = RacingResultHistory()

    fun tryMoveCars(round: Int, conditionNumbers: List<Int>) {
        cars.zip(conditionNumbers)
            .forEach { (car, number) -> car.tryMove(number) }
        racingResultHistory.logging(round, cars = cars)
    }

    fun getRacingHistories() = racingResultHistory.getResults()

    fun size(): Int = cars.size

    fun getWinner(): List<Car> {
        val maxPosition = cars.map { it.position }.max()
        return cars.filter { it.position == maxPosition }
    }
}
