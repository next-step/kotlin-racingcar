package racing_car.game

import racing_car.game.ui.InputConsole
import racing_car.game.ui.InputReceiver
import racing_car.game.ui.Screen

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
