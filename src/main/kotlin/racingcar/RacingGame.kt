package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    private lateinit var cars: Cars
    private var tryCount: Int = 0

    init {
        prepare()
    }

    fun prepare() {
        val carsSize = InputView.receiveCarsSize()
        cars = Cars(List(carsSize) { Car() })
        tryCount = InputView.receiveTryCount()
    }

    fun run() {
        ResultView.init()
        repeat(tryCount) {
            cars.moveAll()
            ResultView.printResult(cars.getPositions())
        }
    }
}
