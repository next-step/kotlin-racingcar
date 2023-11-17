package racingcar

import racingcar.controller.RacingController

private val racingController: RacingController = RacingController()
fun main() {
    val playRacingCar = racingController.play()
    racingController.win(playRacingCar)
}
