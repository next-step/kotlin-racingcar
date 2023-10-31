package carRacing.model

import carRacing.RaceRuleType

data class CarStatus(val name: String = "", val curPosition: Int)
data class RaceResult(val round: Int, val CarStatus: List<CarStatus>)

class RaceOrganizer(private val cars: List<Car>) {
    private var results: MutableList<RaceResult> = mutableListOf();
    private fun tryRound(cars: List<Car>, rule: RaceRuleType) {
        this.cars.forEach { it.tryRace(rule) }
    }

    fun startRace(tryCount: Int, rule: RaceRuleType) {
        for (i in 0 until tryCount) {
            tryRound(cars, rule)
            val result = RaceResult(round = i + 1, CarStatus = cars.map { CarStatus(curPosition = it.curPosition, name = it.carName) })
            results.add(result)
        }
    }

    fun getRaceResult() = this.results
}
