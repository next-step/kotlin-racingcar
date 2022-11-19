package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.GameJudgment
import racingcar.domain.ParticipatedCars
import racingcar.domain.strategy.MoveStrategy
import racingcar.view.OutputView
import racingcar.view.ParticipateCarName

object RacingGameController {
    private const val FIRST_TURN = 1

    fun play(
        nameOfCars: List<ParticipateCarName>,
        numberOfAttempts: Int,
        moveStrategy: MoveStrategy
    ): List<String> {
        val participatingCars = loadCar(nameOfCars)

        return start(participatingCars, numberOfAttempts, moveStrategy)
    }

    private fun loadCar(nameOfCars: List<ParticipateCarName>): List<Car> =
        nameOfCars.map { Car(name = it.name) }

    private fun start(
        cars: List<Car>,
        numberOfAttempts: Int,
        moveStrategy: MoveStrategy
    ): List<String> {
        val participatedCars = ParticipatedCars(moveStrategy)
        val finalTurnCarsInfo = participatedCars.turn(FIRST_TURN, numberOfAttempts, cars, OutputView::showMovingCarResult)

        return GameJudgment(finalTurnCarsInfo).getWinners()
    }
}
