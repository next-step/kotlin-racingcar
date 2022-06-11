package study.racingCar.view

object ResultView {
    fun printResult(gameResults: List<List<Pair<String, Int>>>) {
        gameResults.forEach { mileageRecords ->
            mileageRecords.forEach { (name, mileage) ->
                println("$name : ${"-".repeat(mileage)}")
            }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }
}
