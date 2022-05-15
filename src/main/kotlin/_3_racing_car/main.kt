package _3_racing_car

import _3_racing_car.ui.Game
import _3_racing_car.ui.InputView

fun main() {
    val input = InputView()
    val game = Game()
    val result = game.play(input.read())

    result.print()
}
