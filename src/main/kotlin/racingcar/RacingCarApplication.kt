package racingcar

import racingcar.service.CarGame
import racingcar.view.InputView

object RacingCarApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val carCount = InputView.readCarCount()
        val tryCount = InputView.readTryCount()

        val carGame = CarGame(carCount)

        println("\n실행결과")
        repeat(tryCount) {
            carGame.play()
            carGame.printDashboard { car ->
                car.repeatForEachPosition { print("-") }
                println()
            }
            println()
        }
    }
}
