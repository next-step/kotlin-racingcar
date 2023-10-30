package step3.carRacing.model

data class CarData(val name: String = "", val curPosition: Int)
data class RaceResult(val round: Int, val carData: List<CarData>)

class RaceOrganizer(private val cars: List<Car>) {
    private var results: MutableList<RaceResult> = mutableListOf()
    private fun tryRound(cars: List<Car>, rule: () -> Boolean) {
        this.cars.forEach { it.tryRace(rule) } // TODO: Race rules를 생성시 주입받도록 한다
    }

    fun startRace(tryCount: Int, rule: () -> Boolean) {
        for (i in 0 until tryCount) {
            tryRound(cars, rule)
            val result = RaceResult(round = i + 1, carData = cars.map { CarData(curPosition = it.getCurPosition()) })
            results.add(result)
        }
    }

    fun getRaceResult() = this.results
}
