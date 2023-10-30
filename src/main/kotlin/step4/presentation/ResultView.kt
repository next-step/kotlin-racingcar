package step4.presentation

import step4.data.RacingCar

object ResultView {
    fun getCarMoveView(car: RacingCar): String {
        val moveCnt = visualizeMoveCount(car.moveCount)
        return "${car.name} : $moveCnt"
    }

    private fun visualizeMoveCount(moveCount: Int): String {
        return "-".repeat(moveCount)
    }

    fun getFinalResultView(winnerList: List<RacingCar>): String {
        return StringBuilder().apply {
            winnerList.forEachIndexed { index, car ->
                append(car.name)
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
