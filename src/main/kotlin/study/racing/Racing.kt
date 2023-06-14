package study.racing

import study.racing.car.Car
import study.racing.car.CarRanker
import study.racing.car.factory.CarFactory
import study.racing.movement.condition.MovementConditionGenerator
import study.racing.resultview.ResultView

class Racing(
    private val carFactory: CarFactory,
    private val movementConditionGenerator: MovementConditionGenerator,
    private val carRanker: CarRanker,
    private val racingProgressResultView: ResultView,
    private val afterRacingFinishedResultView: ResultView
) {

    fun start(numOfRace: Int) {
        runStages(numOfRace, carFactory.create())
    }

    private fun runStages(totalRounds: Int, cars: List<Car>) {
        println("실행 결과")
        (0..totalRounds).forEach { _ ->
            cars.forEach { it.move(movementConditionGenerator.execute()) }
            racingProgressResultView.printResult(cars)
        }
        afterRacingFinishedResultView.printResult(carRanker.getWinners(cars))
    }
}
