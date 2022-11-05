package game.racingcar

import game.racingcar.dto.LocationSnapshot
import game.racingcar.view.InputView
import game.racingcar.view.OutputView

class RacingCarGame(
    private val numberOfCars: Int,
    private val numberOfTrials: Int,
) {
    fun play(): List<LocationSnapshot> {
        val locationSnapshots = mutableListOf<LocationSnapshot>()

        val racingCars = RacingCars(numberOfCars)
        repeat(numberOfTrials) {
            with(racingCars) {
                moveAll()
                locationSnapshots.add(LocationSnapshot(locations()))
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
