package racingcar.view

import racingcar.model.Cars

class ResultView : OutputView {
    override fun printHeader() {
        println()
        println(RESULT_MESSAGE)
    }

    override fun showProgress(result: Cars) {
        for (car in result.cars) {
            println(MOVE_GRAPHIC.repeat(car.position))
        }
        println()
    }

    companion object {
        private const val MOVE_GRAPHIC = "-"
        private const val RESULT_MESSAGE = "실행 결과"
    }
}
