package racingcar

import racingcar.domain.CarRacingConfiguration
import racingcar.domain.CarRacingGame
import racingcar.domain.CarRacingResult
import racingcar.domain.RoundResult
import racingcar.view.CarRacingInput
import racingcar.view.CarRacingInputView

object CarRacingRunner {
    fun run() {
        val input = getInput()
        val configuration = createConfiguration(input)
        val result = createResult(configuration)
        val game = createGame(configuration, result)
    }

    private fun getInput(): CarRacingInput = CarRacingInputView.getInputForStart()

    private fun createConfiguration(input: CarRacingInput): CarRacingConfiguration =
        CarRacingConfiguration.of(input)

    private fun createResult(configuration: CarRacingConfiguration): CarRacingResult =
        CarRacingResult.createInitialResult(
            configuration = configuration.getCarRacingResultConfiguration(),
            createInitialRoundResult = { RoundResult.createInitialResult(configuration.getRoundResultConfiguration()) },
        )

    private fun createGame(configuration: CarRacingConfiguration, result: CarRacingResult): CarRacingGame =
        CarRacingGame.set(
            configuration = configuration.getCarRacingGameConfiguration(),
            result = result
        )
}
