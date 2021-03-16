package racingcar.domain

import racingcar.history.RacingResultHistory

class CarCollection(carCount: Int) {

    private val cars: List<Car> = List(carCount) { Car() }
    private val racingResultHistory = RacingResultHistory()

    fun tryMoveCars(round: Int, conditionNumbers: List<Int>) {
        cars.zip(conditionNumbers)
            .forEach { (car, number) -> car.tryMove(number) }
        racingResultHistory.logging(round, cars = cars)
    }

    fun getRacingHistories() = racingResultHistory.getResults()
}
