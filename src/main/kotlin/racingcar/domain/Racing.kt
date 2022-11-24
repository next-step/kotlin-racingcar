package racingcar.domain

import racingcar.dto.ResultDto

class Racing(private val carNames: List<String>, private val strategy: MoveStrategy) {

    private val racing = mutableMapOf<Round, Cars>()

    fun play(roundNumber: Int): ResultDto {
        val cars = Cars.ofNames(carNames, strategy)
        racing[Round(roundNumber)] = cars.moveByStrategy()
        return ResultDto(sumAllRound())
    }

    fun findWinners(): List<Car> {
        return sumAllRound().findWinners()
    }

    private fun sumAllRound(): Cars {
        val cars = racing.values
            .map { it.cars }
            .flatten()
            .groupBy({ it.name }, { it.position })
            .map { Car(name = it.key, position = it.value.reduce { x, y -> x + y }) }
        return Cars(cars, this.strategy)
    }
}
