package study.step3.view

import study.step3.domain.RacingCar

object ResultView {
    fun printResult() {
        val carNum = InputView.inputCarNum()
        val roundNum = InputView.inputRoundNum()
        val racingCar = RacingCar()
        racingCar.raceStart(carNum,roundNum)

        racingCar.moveRecordList.forEach { eachRoundRecord ->
            eachRoundRecord.forEach { movedNum ->
                for (i in 0 until movedNum) print("-")
                println()
            }
            println()
        }
    }
}