package step3

import step3.domain.converter.RaceInputConverter
import step3.domain.game.RaceGame
import step3.view.InputView
import step3.view.ResultView

fun main() {
    val (carCount, round) = InputView.readStartInput()
    val raceGameInfo = RaceInputConverter.convertRaceGameInfo(
        carCountInputString = carCount,
        roundInputString = round,
    )

    val raceGame = RaceGame(raceGameInfo = raceGameInfo)
    ResultView.printStartGame()

    while (raceGame.isProgress()) {
        val carsPosition = raceGame.race()
        ResultView.printCarsPosition(carsPosition = carsPosition)
    }
}
