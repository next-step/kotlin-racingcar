package carRacing.domain

class Racing(private val carList: List<Car>) {
    fun getRaceResult(tryCount: Int): RacingResult = start(this.carList, tryCount)

    private fun start(carList: List<Car>, tryCount: Int): RacingResult {
        val racingResult: RacingResult = RacingResult()

        repeat(tryCount) {
            val copyCarList: List<Car> = process(carList).map { it.copy() }

            racingResult.add(copyCarList)
        }

        return racingResult
    }

    private fun process(carList: List<Car>): List<Car> {
        carList.forEach(Car::move)

        return carList
    }
}
