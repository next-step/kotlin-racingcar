package racing

import racing.Constants.RESULT_MESSAGE
import racing.gamerule.RacingGame
import racing.gamerule.RacingGame.getWinner
import racing.gamerule.RandomMovingStrategy

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
