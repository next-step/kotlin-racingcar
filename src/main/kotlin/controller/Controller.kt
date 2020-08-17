package controller

import racingcarwinner.domain.RacingGame
import racingcarwinner.view.InputView

fun main() {

    val cars = InputView.inputcarname()
    val track = InputView.inputcircuitnumber()
    val race = RacingGame(cars)
    race.moveTrack(track)
    race.findWinner()
}