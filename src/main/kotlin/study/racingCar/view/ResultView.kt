package study.racingCar.view

object ResultView {
    fun printResult(mileageRecords: List<List<Pair<String, Int>>>) {
        mileageRecords.forEach { eachTryRecords ->
            eachTryRecords.forEach { (name, mileage) ->
                println("${name} : ${"-".repeat(mileage)}")
            }
            println()
        }
    }

    fun printWinners(winners: String) {
        println("${winners}가 최종 우승했습니다.")
    }
}
