package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    private lateinit var cars: Cars
    private var tryCount: Int = 0

    init {
        prepare()
    }

    private fun prepare() {
        val carsSize = InputView.receiveCarsSize()
        cars = Cars(List(carsSize) { Car() })
        tryCount = InputView.receiveTryCount()
    }

    fun run() {
        ResultView.init()
        repeat(tryCount) {
            ResultView.printResult(cars.moveAll())
        }
    }
}
