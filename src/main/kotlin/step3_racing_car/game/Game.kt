package step3_racing_car.game

import step3_racing_car.game.ui.InputConsole
import step3_racing_car.game.ui.InputReceiver
import step3_racing_car.game.ui.Screen

class Game(private val receiver: InputReceiver) {
    fun start() {
        val (numOfCar, numOfGame) = InputConsole(receiver).run()
        Cars.register(numOfCar)
        repeat(numOfGame) {
            Cars.list.forEach { it.move((0..9).random()) }
            Screen.show(Cars.list)
        }
    }
}
