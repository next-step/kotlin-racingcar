package racingcar

import racingcar.tasks.Game
import racingcar.ui.getCountOfCar
import racingcar.ui.getCountOfGame

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
