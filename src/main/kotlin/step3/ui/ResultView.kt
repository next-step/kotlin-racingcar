package step3.ui

import step3.Cars

class ResultView {

    fun showResult(cars: Cars, movCount: Int) {
        println(PLAY_RESULT)
        for(i in 0 until movCount) {
            showResultMoveHyphen(cars, i)
        }
    }

    private fun showResultMoveHyphen(cars: Cars, movCount: Int) {
        for (j in 0 until cars.carList.size) {
            val position = cars.carList[j].positionList[movCount]
            print(cars.carList[j].name + " : ")
            repeat(position) {
                print(MOVE_HYPHEN)
            }
            println()
        }
        println()
    }

    fun printWinnerList(winnerList: List<String>) {
        val namesList = winnerList.joinToString(COMMA_SPACE)
        val winnerMessage = "$namesList$WINNER_MESSAGE"
        print(winnerMessage)
    }

    companion object {
        const val PLAY_RESULT = "실행 결과:"
        const val MOVE_HYPHEN = "-"
        const val COMMA_SPACE = ", "
        const val WINNER_MESSAGE = " 가 최종 우승하였습니다."
    }
}

