package racingcar.controller

import racingcar.domain.car.CapturedCar
import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.domain.game.CarRacingGame
import racingcar.domain.game.RoundCount
import racingcar.domain.result.CarRacingReferee
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.RandomMoveRule

object CarRacingController {
    fun run(request: CarRacingRequest): CarRacingResponse {
        val game = CarRacingGame.set(
            roundCount = RoundCount(request.roundCount),
            cars = createCars(request.carNames),
            moveRule = RandomMoveRule()
        )
        val result = game.run()
        return createResponse(result, getWinner(result))
    }

    private fun createCars(carNames: List<String>): List<Car> = CarGenerator.create(carNames)

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
