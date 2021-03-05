package racingcar.game

import racingcar.game.ui.InputConsole
import racingcar.game.ui.InputReceiver
import racingcar.game.ui.Screen

class Game(private val receiver: InputReceiver) {
    fun start() {
        val (numOfCar, numOfGame) = InputConsole(receiver).run()
        val participant = Participant(numOfCar)

        repeat(numOfGame) {
            participant.cars.forEach { it.move((0..9).random()) }
            Screen.show(participant.cars)
        }
    }
}
