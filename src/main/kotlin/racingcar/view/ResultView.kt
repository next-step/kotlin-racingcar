package racingcar.view

import racingcar.car.MoveResults

object ResultView {
    private const val DASH_VIEW = "-"

    fun showRecordsAsDash(results: MoveResults) {
        results.result.map { result ->
            showResultView(result.carName, getDashView(result.moveDistance))
        }
        println()
    }

    private fun showResultView(carName: String, dash: String) {
        println("$carName : $dash")
    }

    private fun getDashView(moveDistance: Int): String {
        return DASH_VIEW.repeat(moveDistance)
    }
}
