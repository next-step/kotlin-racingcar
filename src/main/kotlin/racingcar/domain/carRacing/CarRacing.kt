package racingcar.domain.carRacing

import racingcar.domain.carIndicator.IndicatorGenerator
import racingcar.domain.carRacing.dto.CarRacingResult
import racingcar.domain.carRacing.dto.CarRecord
import racingcar.domain.carRacing.dto.TurnRecord

class CarRacing(private val cars: List<Car>) {
    private val records: MutableList<TurnRecord> = mutableListOf()
    private var maxDistance = 0

    fun start(indicatorGenerator: IndicatorGenerator, turnCount: Int) {
        val indicators = indicatorGenerator.generate(cars.size, turnCount)
        repeat(turnCount) { turn ->
            val indicator = indicators[turn]

            val turnRecord = cars
                .onEachIndexed { index, car ->
                    car.go(indicator.findByCarIndex(index))
                    recordMaxDistance(car)
                }
                .map {
                    CarRecord(it, it.currentDistance())
                }
            this.records.add(TurnRecord(turnForResult(turn), turnRecord))
        }
    }

    private fun turnForResult(turn: Int) = turn + 1

    private fun recordMaxDistance(car: Car) {
        maxDistance = maxDistance.coerceAtLeast(car.currentDistance())
    }

    fun result(): CarRacingResult {
        return CarRacingResult(
            winners = determineWinners(),
            records = this.records
        )
    }

    private fun determineWinners(): List<Car> {
        val finalTurnRecord = records.last()
        return finalTurnRecord.results
            .filter { it.distance == maxDistance }
            .map { it.car }
    }
}
