package racingcar.view.output

import racingcar.model.Car
import racingcar.model.RacingGame

class DefaultResultView : ResultView {

    override fun printRacingGame(racingGame: RacingGame) {
        if (racingGame.currentStep == 1) {
            println("실행 결과")
        }
        racingGame.carList.forEach { println(it.toDisplayString()) }
        println()

        if (racingGame.isOver) {
            println("Game over")
        }
    }

    private fun Car.toDisplayString() = "-".repeat(this.position + 1)
}
