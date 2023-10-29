package racingcar

import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.game.CarRacingGame
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.MoveRule
import racingcar.domain.rule.RandomMoveRule
import racingcar.view.CarRacingInput
import racingcar.view.CarRacingInputView
import racingcar.view.CarRacingOutput
import racingcar.view.CarRacingOutputView

object CarRacingRunner {
    fun run() {
        val input = getInput()
        val configuration = createConfiguration(input)
        val result = setResult(configuration)
        val game = setGame(
            configuration = configuration,
            result = result
        )
        game.run()
        drawOutput(result)
    }

    private fun getInput(): CarRacingInput = CarRacingInputView.getInputForStart()

    private fun setResult(configuration: CarRacingConfiguration): CarRacingResult =
        CarRacingResult.createInitialResult(
            configuration = configuration.getCarRacingResultConfiguration(),
        )

    private fun setGame(
        configuration: CarRacingConfiguration,
        result: CarRacingResult,
    ): CarRacingGame {
        val moveRule = createRandomMoveRule()
        return createGame(
            configuration = configuration,
            result = result,
            moveRule = moveRule
        )
    }

    private fun createConfiguration(input: CarRacingInput): CarRacingConfiguration =
        CarRacingConfiguration.of(input)

    private fun createRandomMoveRule(): RandomMoveRule = RandomMoveRule()

    private fun createGame(
        configuration: CarRacingConfiguration,
        result: CarRacingResult,
        moveRule: MoveRule,
    ): CarRacingGame =
        CarRacingGame.set(
            configuration = configuration.getCarRacingGameConfiguration(),
            result = result,
            moveRule = moveRule,
        )

    private fun drawOutput(
        result: CarRacingResult,
    ) {
        val roundResult = result.showCarPositionsByRoundInOrder()
        val output = CarRacingOutput(roundResult)
        CarRacingOutputView.draw(output)
    }
}
