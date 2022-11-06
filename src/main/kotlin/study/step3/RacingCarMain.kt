package study.step3

import study.step3.model.RacingCar
import study.step3.util.RandomDigit
import study.step3.view.InputView.inputRacingCarInfo
import study.step3.view.ResultView.resultRacingCar

fun main() {
    try {
        val (numberCars, repeatRace) = inputRacingCarInfo()

        val racingCar = RacingCar(numberCars, repeatRace, RandomDigit())
        racingCar.race()

        resultRacingCar(racingCar.getCars(), repeatRace)
    } catch (e: Exception) {
        println("주의: ${e.message}")
    }
}
