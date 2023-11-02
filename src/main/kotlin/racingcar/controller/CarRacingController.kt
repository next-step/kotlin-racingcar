package racingcar.controller

import racingcar.domain.CarRacingReferee
import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.domain.game.CarRacingGame
import racingcar.domain.game.RoundCount
import racingcar.domain.result.CarRacingResult
import racingcar.domain.rule.RandomMoveRule

object CarRacingController {
    fun run(request: CarRacingRequest): CarRacingResponse {
        val cars = createCars(request.carNames)
        val game = CarRacingGame.set(
            roundCount = RoundCount(request.roundCount),
            cars = cars,
            moveRule = RandomMoveRule()
        )
        val result = game.run()
        return createResponse(result, getWinner(cars))
    }

    private fun createCars(carNames: List<String>): List<Car> = CarGenerator.create(carNames)

    private fun getWinner(cars: List<Car>): List<Car> = CarRacingReferee.getWinners(cars)

    private fun createResponse(
        result: List<CarRacingResult>,
        winners: List<Car>,
    ): CarRacingResponse =
        CarRacingResponse(
            results = result,
            winners = winners.map { it.name }
        )
}
