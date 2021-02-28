package step3

import step3.tasks.Game
import step3.ui.getCountOfCar
import step3.ui.getCountOfGame

fun main() {
    run(Game())
}

private fun run(game: Game) {
    val listOfCar = game.setting(getCountOfCar())
    repeat(getCountOfGame()) {
        game.run(listOfCar)
        println()
    }
}
