package racing

import racing.domain.Cars
import racing.domain.Game
import racing.view.GameInputView

fun main() {
    val nameOfRacingCars = GameInputView.inputNameOfRacingCars()
    val racingRound = GameInputView.inputRacingRound()
    println()

    val cars = Cars.createCars(nameOfRacingCars)
    val game = Game(cars, racingRound)

    game.play()
}
