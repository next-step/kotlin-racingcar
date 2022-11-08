package study.step4

import study.step4.model.RacingCar
import study.step4.util.RandomDigit
import study.step4.view.InputGenerator
import study.step4.view.InputView.inputRacingCarInfo
import study.step4.view.ResultView.resultRacingCar

fun main() {
    runCatching {
        val (racingCarNames, repeatRace) = inputRacingCarInfo()
        val racingCarNamesList = InputGenerator.convertRacingCarNamesList(racingCarNames)

        val racingCar = RacingCar(racingCarNamesList, repeatRace, RandomDigit())
        racingCar.race()
        resultRacingCar(racingCar.getChampions(), racingCar.getCars(), repeatRace)
    }.onFailure { e ->
        println("주의: ${e.message}")
    }
}
