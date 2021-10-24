package racing

import racing.domain.Cars
import racing.domain.Pedal
import racing.domain.RacingController
import racing.domain.Round
import racing.view.InputView

fun main() {
    RacingApplication.run()
}

object RacingApplication {
    fun run() {
        val carNames = InputView.getCar()
        val round = Round.make(InputView.getRound()).round
        val cars = Cars.make(carNames = carNames)
        val pedal = Pedal(4)

        RacingController.printStart()
        repeat(round) {
            RacingController.race(cars = cars, pedal = pedal)
            RacingController.printRound(cars)
        }
        RacingController.printResult(cars)
    }
}
