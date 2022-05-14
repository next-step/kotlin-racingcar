package step3.ui

import step3.Cars

class ResultView {

    fun showResult(cars: Cars, movCount: Int) {
        println(PLAY_RESULT)
        for(i in 0 until movCount) {
            showResultMoveHyphen(cars, i)
        }
        printWinnerList(getWinnerList(cars))
    }

    private fun showResultMoveHyphen(cars: Cars, movCount: Int) {
        for (j in 0 until cars.carList.size) {
            val position = cars.carList[j].positionList[movCount]
            print(cars.carList[j].getCarName() + " : ")
            repeat(position) {
                print(MOVE_HYPHEN)
            }
            println()
        }
        println()
    }

    private fun getWinnerList(cars: Cars):List<String> {
        val winnerList = ArrayList<String>()
        var max = 0
        for (j in 0 until cars.carList.size) {
            val position = cars.carList[j].getPosition()
            if(position >= max && position != 0) {
                max = position
                winnerList.add(cars.carList[j].getCarName())
            }
        }
        return winnerList
    }

    private fun printWinnerList(winnerList: List<String>) {
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

