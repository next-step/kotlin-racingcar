package racingcar

import racingcar.controller.RacingController

private val racingController: RacingController = RacingController()
fun main() {
    val joinRacingCar = racingController.join()
    val playRacingCar = racingController.play(joinRacingCar)
    racingController.winner(playRacingCar)
}
