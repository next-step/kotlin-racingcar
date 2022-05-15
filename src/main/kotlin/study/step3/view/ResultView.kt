package study.step3.view

import study.step3.domain.RacingCar

object ResultView {
    fun printResult() {
        val racingCar = RacingCar()
        racingCar.raceStart()
    }
}