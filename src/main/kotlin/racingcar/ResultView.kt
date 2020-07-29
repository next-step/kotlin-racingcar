package racingcar

object ResultView {
    private const val TEXT_RACING_RESULT = "실행 결과"
    private const val TEXT_NOTIFY_WINNER = "이(가) 최종 우승했습니다 !!!"
    private const val DISTANCE_MARK = "-"

    private fun showResultTitle() = println(TEXT_RACING_RESULT)

    fun showRace(gameRecords: List<LinkedHashMap<String, Int>>) {
        println()
        showResultTitle()

        gameRecords.forEach { nthRun ->
            printRecords(nthRun)
            println()
        }
    }

    private fun printRecords(nthRun: HashMap<String, Int>) {
        nthRun.forEach { eachCar ->
            showCarNamesAndDistancesMoved(eachCar)
        }
    }

    private fun showCarNamesAndDistancesMoved(eachCar: Map.Entry<String, Int>) {
        // print each car's name and distance
        print("${eachCar.key}: " + DISTANCE_MARK.repeat(eachCar.value))
        println()
    }

    fun notifyWinner(winners: List<String>) {
        if (winners.size == 1) print(winners[0])
        if (winners.size > 1) {
            printWinnerUntilBeforeLastOne(winners)
            print(winners.last())
        }
        print(TEXT_NOTIFY_WINNER)
    }

    private fun printWinnerUntilBeforeLastOne(winners: List<String>) {
        for (i in 0 until winners.size - 1)
            print("${winners[i]}, ")
    }
}
