package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.GameJudgment
import racingcar.domain.ParticipateCarName
import racingcar.domain.ParticipatedCars
import racingcar.domain.strategy.MoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingGameController {
    private const val FIRST_TURN = 1

    fun play(
        moveStrategy: MoveStrategy
    ) {
        val nameOfCars = InputView.getParticipateCarNames()
        val numberOfAttempts = InputView.getNumberOfAttempts()

        val participatingCars = loadCar(nameOfCars)
        val winners = start(participatingCars, numberOfAttempts, moveStrategy)

        OutputView.showWinners(winners)
    }

    private fun loadCar(nameOfCars: List<String>): List<Car> =
        nameOfCars.map { Car(participateCarName = ParticipateCarName(it)) }

    private fun start(
        cars: List<Car>,
        numberOfAttempts: Int,
        moveStrategy: MoveStrategy
    ): List<String> {
        val participatedCars = ParticipatedCars(moveStrategy)
        val finalTurnCarsInfo =
            participatedCars.turn(FIRST_TURN, numberOfAttempts, cars, OutputView::showMovingCarResult)

        return GameJudgment(finalTurnCarsInfo).getWinners()
    }
}
