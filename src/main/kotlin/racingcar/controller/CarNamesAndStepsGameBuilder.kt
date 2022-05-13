package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.input.CarNamesAndSteps

class CarNamesAndStepsGameBuilder : GameBuilder<CarNamesAndSteps> {

    override fun createGame(argument: CarNamesAndSteps): RacingGame {
        return RacingGame(
            namesOfCar = argument.carNames,
            stepsToTry = argument.stepsToTry
        )
    }
}
