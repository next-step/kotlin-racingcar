package study.step4

import study.step3.model.RacingCar
import study.step3.util.RandomDigit
import study.step3.view.InputView.inputRacingCarInfo
import study.step3.view.ResultView.resultRacingCar

fun main() {
    runCatching {
        val (numberCars, repeatRace) = inputRacingCarInfo()

        val racingCar = RacingCar(numberCars, repeatRace, RandomDigit())
        racingCar.race()
        resultRacingCar(racingCar.getCars(), repeatRace)
    }.onFailure { e ->
        println("주의: ${e.message}")
    }
}
