package study.racingCar.view

object ResultView {
    fun printResult(mileageRecords: List<List<Pair<String, Int>>>) {
        mileageRecords.forEach { eachTryRecords ->
            eachTryRecords.forEach { pair ->
                println("${pair.first} :  " + "-".repeat(pair.second))
            }
            println()
        }
    }

    fun printWinners(movedStepsRecords: List<List<Pair<String, Int>>>) {
        val max = movedStepsRecords.last().maxOf { it.second }
        val winners = movedStepsRecords.last().filter { it.second == max }.joinToString { it.first }
        println("${winners}가 최종 우승했습니다.")
    }
}