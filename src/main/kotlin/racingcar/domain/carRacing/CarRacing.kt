package racingcar.domain.carRacing

import racingcar.application.CarRacingResult
import racingcar.domain.carIndicator.IndicatorGenerator

class CarRacing(private val cars: List<Car>) {
    private val records: MutableList<TurnRecord> = mutableListOf()

    fun start(indicatorGenerator: IndicatorGenerator, turnCount: Int) {
        val indicators = indicatorGenerator.generate(cars.size, turnCount)
        repeat(turnCount) { turn ->
            val indicator = indicators[turn]

            val turnRecord = cars
                .onEachIndexed { index, car ->
                    car.go(indicator.findByCarIndex(index))
                }
                .map {
                    CarRecord(it, it.currentDistance())
                }
            this.records.add(TurnRecord(turnForResult(turn), turnRecord))
        }
    }

    private fun turnForResult(turn: Int) = turn + 1

    fun result(): CarRacingResult {
        return CarRacingResult(
            winners = determineWinners(),
            records = this.records
        )
    }

    private fun determineWinners(): List<Car> {
        val maxDistance = maxDistance()
        return lastRecord().winners(maxDistance)
    }

    private fun maxDistance() = lastRecord().results.maxOf { it.distance }

    private fun lastRecord() = records.last()
}
