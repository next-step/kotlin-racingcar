package game.racingcar

import game.racingcar.view.InputView
import game.racingcar.view.OutputView

class RacingCarGame(
    private val numberOfCars: Int,
    private val numberOfTrials: Int,
) {
    fun play(): List<List<Int>> {
        val locationSnapshots = mutableListOf<List<Int>>()

        val racingCars = RacingCars(numberOfCars)
        repeat(numberOfTrials) {
            with(racingCars) {
                moveAll()
                locationSnapshots.add(locationSnapshot())
            }
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
