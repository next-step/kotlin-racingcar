package racing.view.result

import racing.model.RacingCars

interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(racingCars: RacingCars)

    fun displayRaceWinners(racingCars: RacingCars)
}
