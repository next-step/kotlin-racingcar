package racingcar.controller

import racingcar.model.Cars
import racingcar.model.Games
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView.countOfCars
import racingcar.view.InputView.countOfGames
import racingcar.view.ResultView

class RacingController {
    fun start() {
        val carList = Cars.createCar(countOfCars())
        val racingGame = Games.of(countOfGames(), ResultView(), RandomNumberGenerator())

        racingGame.play(carList)
    }
}

fun main() {
    val game = RacingController()
    game.start()
}
