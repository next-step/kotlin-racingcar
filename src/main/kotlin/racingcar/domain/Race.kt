package racingcar.domain

class Race(private val raceSetting: RaceSetting) {

    private val cars: List<Car> = List(raceSetting.numberOfCar) { index ->
        Car("${index + 1}번째 자동차")
    }

    private val roundHistories = mutableListOf<RoundHistory>()

    fun run(): RaceResult {
        repeat(raceSetting.totalCountOfRound) { roundNumber: Int ->
            startRound(cars)
            saveRoundHistory(roundNumber, cars)
        }

        return RaceResult(roundHistories)
    }

    private fun startRound(cars: List<Car>) {
        Round(cars).start()
    }

    private fun saveRoundHistory(roundNumber: Int, cars: List<Car>) {
        cars.forEach { car ->
            roundHistories.add(RoundHistory(roundNumber, car.name, car.position))
        }
    }
}
