package step4.presentation

import step4.data.RacingCar

object ResultView {
    fun showResultTitle() {
        println("실행 결과")
    }

    fun showCarMove(car: RacingCar) {
        val moveCnt = visualizeMoveCount(car.moveCount)
        println("${car.name} : $moveCnt")
    }

    private fun visualizeMoveCount(moveCount: Int): String {
        return "-".repeat(moveCount)
    }

    fun showFinalResult(winnerList: List<RacingCar>) {
        winnerList.forEachIndexed { index, car ->
            print(car.name)
            printCommaIfNotLast(index != winnerList.size - 1)
        }
        println("가 최종 우승했습니다.")
    }

    private fun printCommaIfNotLast(isNotLast: Boolean) {
        if (isNotLast) print(", ")
    }

    fun lineBreak() {
        println()
    }
}
