package step4_racing_car_winner.game

import step4_racing_car_winner.game.ui.InputConsole
import step4_racing_car_winner.game.ui.InputReceiver
import step4_racing_car_winner.game.ui.Screen
import kotlin.random.Random

object Game {
    fun start(receiver: InputReceiver) {
        val (nameOfCars, numOfGame) = InputConsole(receiver).run()

        Player.register(nameOfCars)

        var num = numOfGame
        while (num-- > 0) {
            move(Player.cars)
            Screen.show(Player.cars, count = numOfGame - num)
        }

        val winners = checkWinner(Player.cars)
        Screen.announcement(winners)
    }

    private fun move(cars: List<Car>) {
        for (car in cars) {
            val rand: Int = Random.nextInt(0, 10)
            if (rand >= 4) car.position++
        }
    }

    private fun checkWinner(cars: List<Car>): List<Car> {
        val max = cars.maxByOrNull { it.position }!!.position
        return cars.filter { it.position == max }
    }
}
