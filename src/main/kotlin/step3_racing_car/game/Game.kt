package step3_racing_car.game

import step3_racing_car.game.ui.InputConsole
import step3_racing_car.game.ui.Screen
import kotlin.random.Random

object Game {
    fun start() {
        val (numOfCar, numOfGame) = InputConsole().run()

        Dashboard.register(numOfCar)

        var num = numOfGame

        while (num > 0) {
            move(Dashboard.cars)
            --num
            println("${numOfGame - num}회차")
            Screen.show(Dashboard.cars)
        }
    }

    fun move(cars: List<Car>) {
        for (car in cars) {
            val rand: Int = Random.nextInt(0, 10)
            if (rand >= 4) car.position++
        }
    }
}
