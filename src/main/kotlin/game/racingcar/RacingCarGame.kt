package game.racingcar

import game.racingcar.dto.LocationSnapshot
import game.racingcar.dto.RacingCarPlayResult
import game.racingcar.move.MoveStrategy
import game.racingcar.move.RandomMoveStrategy
import game.racingcar.view.InputView
import game.racingcar.view.OutputView

class RacingCarGame(
    private val carNames: List<String>,
    private val numberOfTrials: Int,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    fun play(): RacingCarPlayResult {
        val locationSnapshots = mutableListOf<LocationSnapshot>()

        val racingCars = RacingCars(carNames, moveStrategy)
        (1..numberOfTrials).forEach {
            locationSnapshots.add(LocationSnapshot(racingCars.moveAll()))
        }
        return RacingCarPlayResult(locationSnapshots, racingCars.pickWinners())
    }
}

fun main() {
    val (carNames, numberOfTrials) = InputView.getInputFromConsole()

    val racingCarGame = RacingCarGame(carNames, numberOfTrials)
    val racingCarPlayResult = racingCarGame.play()

    OutputView.printOutputToConsole(racingCarPlayResult)
}
