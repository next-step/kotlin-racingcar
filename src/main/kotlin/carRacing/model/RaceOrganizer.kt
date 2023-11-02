package carRacing.model

import carRacing.RaceRuleType

class RaceOrganizer(private val cars: List<Car>) {
    private var results: MutableList<RaceResult> = mutableListOf();
    private fun tryRound(cars: List<Car>, rule: RaceRuleType) {
        this.cars.forEach { it.tryRace(rule) }
    }

    fun startRace(tryCount: Int, rule: RaceRuleType): List<RaceResult> {
        repeat(tryCount) { index ->
            tryRound(cars, rule)
            val result = RaceResult(
                round = index + 1,
                CarRecord = cars.map { CarRecord(curPosition = it.curPosition, name = it.carName) })
            results.add(result)
        }

        return results.toList()
    }
}
