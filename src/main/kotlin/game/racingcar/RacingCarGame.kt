package game.racingcar

import game.racingcar.dto.LocationSnapshot
import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy
import game.racingcar.view.InputView
import game.racingcar.view.OutputView

class RacingCarGame(
    private val numberOfCars: Int,
    private val numberOfTrials: Int,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    fun play(): List<LocationSnapshot> {
        val locationSnapshots = mutableListOf<LocationSnapshot>()

        val racingCars = RacingCars(numberOfCars, moveStrategy)
        (1..numberOfTrials).forEach {
            locationSnapshots.add(LocationSnapshot(racingCars.moveAll()))
        }
        return locationSnapshots
    }
}

fun main() {
    val (numberOfCars, numberOfTrials) = InputView.getInputFromConsole()

    val racingCarGame = RacingCarGame(numberOfCars, numberOfTrials)
    val snapshots = racingCarGame.play()

    OutputView.printOutputToConsole(snapshots)
}
