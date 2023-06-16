package racingcar

import racingcar.view.ResultView

class RacingGame(private val cars: Cars, private val tryCount: Int) {
    fun run() {
        ResultView.init()
        repeat(tryCount) {
            ResultView.printResult(cars.moveAll())
        }
    }
}
