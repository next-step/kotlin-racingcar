package racingcar

import racingcar.domain.car.Car
import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.game.CarRacingGame
import racingcar.domain.result.CarRacingReferee
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule
import racingcar.domain.rule.RandomMoveRule
import racingcar.view.CarRacingInput
import racingcar.view.CarRacingInputView
import racingcar.view.CarRacingOutputView

object CarRacingRunner {
    fun run() {
        val input = getInput()
        val configuration = createConfiguration(input)
        val game = setGame(configuration)
        val result = game.run()
        val winner = CarRacingReferee.getWinners(result)
        drawOutput(result, winner)
    }

    private fun getInput(): CarRacingInput = CarRacingInputView.getInput()

    private fun createConfiguration(input: CarRacingInput): CarRacingConfiguration =
        CarRacingConfiguration.of(input)

    private fun setGame(
        configuration: CarRacingConfiguration,
    ): CarRacingGame {
        val moveRule = createRandomMoveRule()
        return createGame(
            configuration = configuration,
            moveRule = moveRule
        )
    }

    private fun createRandomMoveRule(): RandomMoveRule = RandomMoveRule()

    private fun createGame(
        configuration: CarRacingConfiguration,
        moveRule: MoveRule,
    ): CarRacingGame =
        CarRacingGame.set(
            configuration = configuration,
            moveRule = moveRule,
        )

    private fun drawOutput(
        result: List<CarRacingResult>,
        winners: List<Car>,
    ) {
        CarRacingOutputView.draw(result, winners.map { it.name })
    }
}
