package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.game.CarRacingGame
import racingcar.domain.result.CarRacingReferee
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.RandomMoveRule

object CarRacingController {
    fun run(request: CarRacingRequest): CarRacingResponse {
        val gameResult = startGame(createGame(createConfiguration(request)))
        return createResponse(gameResult, getWinner(gameResult))
    }

    private fun createConfiguration(request: CarRacingRequest): CarRacingConfiguration =
        CarRacingConfiguration.of(request)

    private fun createGame(
        configuration: CarRacingConfiguration,
    ): CarRacingGame = CarRacingGame.set(
        configuration = configuration,
        moveRule = RandomMoveRule(),
    )

    private fun startGame(game: CarRacingGame) = game.run()

    private fun getWinner(result: List<CarRacingResult>): List<Car> = CarRacingReferee.getWinners(result)

    private fun createResponse(
        result: List<CarRacingResult>,
        winners: List<Car>,
    ): CarRacingResponse =
        CarRacingResponse(
            results = result,
            winners = winners.map { it.name }
        )
}
