package study.step3.view

import study.step3.domain.RacingCar

object ResultView {
    fun printResult() {
        val racingCar = RacingCar()
        racingCar.raceStart()

        racingCar.moveRecordList.forEach { eachRoundRecord ->
            eachRoundRecord.forEach { movedNum ->
                for (i in 0 until movedNum) print("-")
                println()
            }
            println()
        }
    }
}