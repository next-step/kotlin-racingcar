package racingcar.domain.car

import racingcar.domain.TrialCount
import racingcar.domain.car.vo.Name
import racingcar.domain.move.MovingStrategy
import racingcar.domain.result.CarRaceResult
import racingcar.domain.result.CarRaceResultForRound

private const val MINIMUM_NUMBER_OF_CARS = 2

class Cars(val values: List<Car>) {

    init {
        require(values.size >= MINIMUM_NUMBER_OF_CARS) { "자동차 경주는 적어도 ${MINIMUM_NUMBER_OF_CARS}대 이상의 자동차가 있어야 가능합니다." }
        require(values.size == values.map { it.name.value }.distinct().size) { "자동차의 이름은 중복될 수 없습니다." }
    }

    fun move(movingStrategy: MovingStrategy, trialCount: TrialCount): CarRaceResult {
        val carRaceResultsForRounds = trialCount.range().map { moveOneRound(movingStrategy) }
        return CarRaceResult(carRaceResultsForRounds)
    }

    private fun moveOneRound(movingStrategy: MovingStrategy): CarRaceResultForRound {
        values.forEach { it.move(movingStrategy) }
        return CarRaceResultForRound(values)
    }

    companion object {
        fun of(names: List<String>): Cars {
            return Cars(names.map { Car(Name(it)) })
        }
    }
}
