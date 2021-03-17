package racingcar

import racingcar.tasks.WinnersReader
import racingcar.tasks.Game
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    run(Game())
}

private fun run(game: Game) {
    val listOfCar = game.setRacingCar(InputView.getInfoOfCars())
    val countOfGame = InputView.getCountOfGame()
    OutputView.noticeResult()
    repeat(countOfGame) {
        game.run(listOfCar)
    }
    OutputView.noticeWinners(WinnersReader(listOfCar).findWinners())
}
