package racingcar.resultviews

import racingcar.Car
import racingcar.GameResult

class RacingGameResultView : ResultView {
    override fun printResult(gameResult: GameResult) {
        for (car in gameResult.cars) {
            val resultStr = buildResultStr(car)
            println(resultStr)
        }
    }

    private fun buildResultStr(car: Car): String {
        var resultStr = "Car ${car.carId}: "
        for (i in 0..car.currentPosition) {
            resultStr += "-"
        }
        return resultStr
    }
}
