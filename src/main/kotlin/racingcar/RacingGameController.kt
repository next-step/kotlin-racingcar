package racingcar

import racingcar.io.ParticipateCarName
import racingcar.strategy.MoveStrategy

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
        val finalTurnCarsInfo = participatedCars.turn(FIRST_TURN, numberOfAttempts, cars)

        return GameJudgment(finalTurnCarsInfo).getWinners()
    }
}
