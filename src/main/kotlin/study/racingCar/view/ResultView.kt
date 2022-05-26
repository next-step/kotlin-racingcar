package study.racingCar.view

object ResultView {
    fun printResult(movedStepsRecords: List<MutableList<Int>>) {

        movedStepsRecords.forEach { eachTryRecords ->
            eachTryRecords.forEach { movedSteps ->
                println("-".repeat(movedSteps))
                println()
            }
            println()
        }
    }
}