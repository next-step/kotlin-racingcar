package step3.ui

import step3.Cars

object ResultView {
    private const val MOVE_HYPHEN = "-"

    fun showResult(cars: Cars, movCount: Int) {
        println("실행 결과:")
        for(i in 0 until movCount) {
            showResultMoveHyphen(cars, i)
        }
    }

    private fun showResultMoveHyphen(cars: Cars, movCount: Int) {
        for (j in 0 until cars.carsList.size) {
            val position = cars.carsList[j].positionList[movCount]
            repeat(position) {
                print(MOVE_HYPHEN)
            }
            println()
        }
        println()
    }
}
