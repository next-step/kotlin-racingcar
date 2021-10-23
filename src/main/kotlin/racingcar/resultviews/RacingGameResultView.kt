package racingcar.resultviews

import racingcar.Car

class RacingGameResultView : ResultView {
    override fun printResult(cars: List<Car>) {
        for (car in cars) {
            val resultStr = buildResultStr(car)
            println(resultStr)
        }
        println("")
    }

    private fun buildResultStr(car: Car): String {
        var resultStr = ""
        for (i in 0..car.currentPosition) {
            resultStr += "-"
        }
        return resultStr
    }
}
