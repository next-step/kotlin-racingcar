package study.step3.domain

import study.step3.view.InputView

class RacingCar {
    lateinit var moveRecordList: List<MutableList<Int>>

    fun raceStart() {
        val carNum = InputView.inputCarNum()
        val roundNum = InputView.inputRoundNum()

        val carList = List(carNum) {}.map { Car() }
        moveRecordList = List(roundNum) {}.map { List(carNum) {}.map { 0 }.toMutableList() }

        for (i in 0 until roundNum) {
            for (j in 0 until carNum) {
                carList[j].moveOneStep()
                moveRecordList[i][j] = carList[j].movedNum
            }
        }
    }
}
