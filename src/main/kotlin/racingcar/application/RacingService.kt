package racingcar.application

import racingcar.domain.Cars
import racingcar.domain.MoveStrategy

class RacingService(private val moveStrategy: MoveStrategy) {

    fun start(roundCount: Int, cars: Cars): RacingResponse {
        val response = mutableListOf<Cars>()
        repeat(roundCount) {
            val racingCars = if (response.isNotEmpty()) response.last() else cars
            response.add(racingCars.move(moveStrategy))
        }

        return RacingResponse(response, response.last().cars)
    }
}
