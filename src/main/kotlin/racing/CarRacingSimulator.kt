package racing

import racing.domain.Constants.RESULT_MESSAGE
import racing.domain.RacingGame
import racing.domain.RacingGame.getWinner
import racing.domain.gamerule.RandomMovingStrategy
import racing.view.CarRacingInputHandler
import racing.view.CarRacingOutputHandler

fun main() {
    val inputParams = CarRacingInputHandler.input()
    CarRacingInputHandler.validate(inputParams.numberOfCars, inputParams.numberOfTries, inputParams.carNames)

    val cars = CarRacingInputHandler.getCars(inputParams)

    println(RESULT_MESSAGE)

    repeat(inputParams.numberOfTries.toInt()) {
        RacingGame.play(cars, RandomMovingStrategy())
        CarRacingOutputHandler.display(cars)
    }

    println(getWinner(cars).joinToString(",") + "가 최종 우승했습니다.")
}
