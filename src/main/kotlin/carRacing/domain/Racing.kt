package carRacing.domain

class Racing(private val carList: List<Car>) {
    fun getRaceResult(tryCount: Int): RacingResult = start(this.carList, tryCount)

    private fun start(carList: List<Car>, tryCount: Int): RacingResult {
        val racingResult: RacingResult = RacingResult(mutableListOf(CarList(carList.toMutableList())))
        repeat(tryCount) {
            val beforeCarList: List<Car> = racingResult.getRacingResultHistory().last().getCarList()

            racingResult.add(process(beforeCarList))
        }

        return racingResult
    }

    private fun process(carList: List<Car>): CarList = CarList(carList.map(Car::move).toMutableList())
}
