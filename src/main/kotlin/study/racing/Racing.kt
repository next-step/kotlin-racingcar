package study.racing

import study.racing.car.Car
import study.racing.car.CarRanker
import study.racing.car.factory.CarListFactory
import study.racing.movement.condition.MovementCondition
import study.racing.resultview.ResultView

class Racing(
    private val CarListFactory: CarListFactory,
    private val carRanker: CarRanker,
    private val movementCondition: MovementCondition,
    private val resultView: ResultView,
) {

    fun start(numOfRace: Int): List<Car> {
        return runStages(numOfRace, CarListFactory.create())
    }

    private fun runStages(totalRounds: Int, cars: List<Car>): List<Car> {
        resultView.printMessage()
        repeat(totalRounds) { _ ->
            cars.forEach { it.move(movementCondition) }
            resultView.printRoundResult(cars)
        }
        val winners = carRanker.getWinners(cars)
        resultView.printWinners(winners)
        return winners
    }
}
