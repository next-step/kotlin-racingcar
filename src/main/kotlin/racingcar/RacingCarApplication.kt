package racingcar

import racingcar.service.CarGame
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingCarApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val carCount = InputView.readCarCount()
        val tryCount = InputView.readTryCount()

        val carGame = CarGame(carCount)

        ResultView.printHeader()
        repeat(tryCount) {
            carGame.play()
            ResultView.printDashBoard(carGame)
        }
    }
}
