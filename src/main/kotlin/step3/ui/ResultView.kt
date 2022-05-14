package step3.ui

import step3.Cars

object ResultView {
    private const val MOVE_HYPHEN = "-"

    fun showResult(cars: Cars, movCount: Int) {
        println("실행 결과:")
        for(i in 0 until movCount) {
            showResultMoveHyphen(cars, i)
        }
        printWinnerList(getWinnerList(cars))
    }

    private fun showResultMoveHyphen(cars: Cars, movCount: Int) {
        for (j in 0 until cars.carsList.size) {
            val position = cars.carsList[j].positionList[movCount]
            print(cars.carsList[j].getCarName() + " : ")
            repeat(position) {
                print(MOVE_HYPHEN)
            }
            println()
        }
        println()
    }

    private fun getWinnerList(cars: Cars):List<String> {
        val winnerList: MutableList<String> = ArrayList<String>()
        var max = 0
        var winners: String? = null
        for (j in 0 until cars.carsList.size) {
            val position = cars.carsList[j].getPosition()
            if(position > max) {
                max = position
                winnerList.add(cars.carsList[j].getCarName())
            }
        }
        return winnerList
    }

    private fun printWinnerList(winnerList: List<String>) {
        val namesList = winnerList.joinToString(", ")
        val winnerMessage = "$namesList 가 최종 우승하였습니다."
        print(winnerMessage)
    }
}
