package study.step3

import study.step3.model.RacingCar
import study.step3.view.InputView.Companion.input
import study.step3.view.ResultView.Companion.result

fun main() {
    val (numberCars, repeatRace) = input()

    val racingCar = RacingCar(numberCars, repeatRace)
    racingCar.race()

    result(racingCar.cars(), repeatRace)
}
