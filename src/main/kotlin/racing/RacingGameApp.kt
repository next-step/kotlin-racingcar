package racing

import racing.domain.CarsFactory
import racing.domain.Game
import racing.view.GameInputView

fun main() {
    val nameOfRacingCars = GameInputView.inputNameOfRacingCars()
    val racingRound = GameInputView.inputRacingRound()
    println()

    val cars = CarsFactory.createCars(nameOfRacingCars)
    val game = Game(cars, racingRound)

    game.play()
}
