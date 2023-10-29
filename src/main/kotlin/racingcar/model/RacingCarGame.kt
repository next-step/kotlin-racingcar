package racingcar.model

import racingcar.strategy.MovingStrategy

class RacingCarGame(
    val cars: List<Car>,
    private val strategy: MovingStrategy,
) {
    fun run(numbersOfTry: Int): List<RacingHistory> {
        val racingHistories = mutableListOf<RacingHistory>()
        for (i in 1..numbersOfTry) {
            val carHistories = mutableListOf<Car>()
            cars.forEach {
                it.stepForward(strategy.canMove())
                val movedCar = Car(it.name)
                movedCar.moveTo(it.position)
                carHistories.add(movedCar)
            }
            racingHistories.add(RacingHistory(i, carHistories))
        }

        return racingHistories
    }
}
