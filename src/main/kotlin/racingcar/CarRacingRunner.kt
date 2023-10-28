package racingcar

import racingcar.domain.CarRacingConfiguration
import racingcar.domain.CarRacingGame
import racingcar.domain.CarRacingResult
import racingcar.domain.CarRacingRoundResult
import racingcar.domain.MoveRule
import racingcar.domain.RandomMoveRule
import racingcar.domain.RandomNumberGeneratorInBound
import racingcar.view.CarRacingInput
import racingcar.view.CarRacingInputView

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
    }

    private fun getInput(): CarRacingInput = CarRacingInputView.getInputForStart()

    private fun setResult(configuration: CarRacingConfiguration): CarRacingResult =
        CarRacingResult.createInitialResult(
            configuration = configuration.getCarRacingResultConfiguration(),
            createInitialRoundResult = { CarRacingRoundResult.createInitialResult(configuration.getRoundResultConfiguration()) },
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

    private fun createRandomMoveRule(): RandomMoveRule = RandomMoveRule(RandomNumberGeneratorInBound())

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
}
