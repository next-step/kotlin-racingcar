package step4.presentation

import step4.domain.RacingCar
import step4.domain.RacingCars

object ResultView {
    fun showCarMoveView(cars: RacingCars) {
        for (car in cars.carList) {
            println(getCarMoveView(car))
        }
        println()
    }

    fun getCarMoveView(car: RacingCar): String {
        return "${car.carName.name} : ${visualizeMoveCount(car.moveCount)}"
    }

    private fun visualizeMoveCount(moveCount: Int): String {
        return "-".repeat(moveCount)
    }

    fun showFinalResultView(winnerList: List<RacingCar>) {
        println(getFinalResultView(winnerList))
    }

    fun getFinalResultView(winnerList: List<RacingCar>): String {
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
}
