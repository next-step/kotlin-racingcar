package racingCarMVC

import racingCarMVC.controller.RacingController

fun main() {
    val racingController = RacingController()
    val inputData = racingController.inputData()
    racingController.racingStart(inputData)
}
