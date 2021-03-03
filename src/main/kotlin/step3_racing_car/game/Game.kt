package step3_racing_car.game

import step3_racing_car.game.ui.InputConsole
import step3_racing_car.game.ui.InputReceiver
import step3_racing_car.game.ui.Screen
import kotlin.random.Random

object Game {
    fun start(receiver: InputReceiver) {
        val (numOfCar, numOfGame) = InputConsole(receiver).run()

        Player.register(numOfCar)

        var num = numOfGame

        while (num-- > 0) {
            move(Player.cars)
            Screen.show(Player.cars, count = numOfGame - num)
        }
    }

    fun move(cars: List<Car>) {
        for (car in cars) {
            val rand: Int = Random.nextInt(0, 10)
            if (rand >= 4) car.position++
        }
    }
}
