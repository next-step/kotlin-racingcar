package racingcar.controller

import racingcar.domain.car.CapturedCar
import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.game.CarRacingGame
import racingcar.domain.result.CarRacingReferee
import racingcar.domain.result.CarRacingResult

object CarRacingController {
    fun run(request: CarRacingRequest): CarRacingResponse {
        val gameResult = startGame(createGame(createConfiguration(request)))
        return createResponse(gameResult, getWinner(gameResult))
    }

    private fun createConfiguration(request: CarRacingRequest): CarRacingConfiguration =
        CarRacingConfiguration.of(request.roundCount, request.carNames)

    private fun createGame(
        configuration: CarRacingConfiguration,
    ): CarRacingGame = CarRacingGame.set(configuration)

    private fun startGame(game: CarRacingGame) = game.run()

    private fun getWinner(result: List<CarRacingResult>): List<CapturedCar> = CarRacingReferee.getWinners(result)

    private fun createResponse(
        result: List<CarRacingResult>,
        winners: List<CapturedCar>,
    ): CarRacingResponse =
        CarRacingResponse(
            results = result,
            winners = winners.map { it.name }
        )
}
