package step4.presentation

import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.domain.RacingGameResult
import step4.domain.ResultView

class RacingGameResultView : ResultView<RacingGameResult> {
    override fun showResult(resultInfo: RacingGameResult) {
        for (cars in resultInfo.racingResultList) {
            println(getMiddleResultText(cars))
        }

        val last = resultInfo.racingResultList.last()
        println(getFinalResult(last.winner))
    }

    private fun getMiddleResultText(cars: RacingCars): String {
        return StringBuilder().apply {
            for (car in cars.carList) {
                appendLine(getCarMoveView(car))
            }
        }.toString()
    }

    private fun getCarMoveView(car: RacingCar): String {
        return "${car.carName.name} : ${visualizeMoveCount(car.moveCount)}"
    }

    private fun visualizeMoveCount(moveCount: Int): String {
        return CAR_MOVE.repeat(moveCount)
    }

    fun getFinalResult(winnerList: List<RacingCar>): String {
        return StringBuilder().apply {
            winnerList.forEachIndexed { index, car ->
                append(car.carName.name)
                append(getCommaIfNotLast(index != winnerList.size - 1))
            }
            append("가 최종 우승했습니다.")
        }.toString()
    }

    private fun getCommaIfNotLast(isNotLast: Boolean): String {
        return if (isNotLast) ", "
        else ""
    }

    companion object {
        const val CAR_MOVE = "-"
    }
}
