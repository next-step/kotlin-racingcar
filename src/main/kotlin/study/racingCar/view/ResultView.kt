package study.racingCar.view

object ResultView {
    fun printResult(movedStepsRecords: List<List<Int>>) {

        movedStepsRecords.forEach { eachTryRecords ->
            eachTryRecords.forEach { movedSteps ->
                println("-".repeat(movedSteps))
            }
            println()
        }
    }
}