package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.input.NumberAndSteps

class NumberAndStepsGameBuilder : GameBuilder<NumberAndSteps> {

    override fun createGame(argument: NumberAndSteps): RacingGame {
        return RacingGame(
            numberOfCar = argument.numberOfCar,
            stepsToTry = argument.stepsToTry
        )
    }
}
