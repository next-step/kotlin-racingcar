package racingcar

object RaceHost {

    fun play(rounds: Rounds, carNames: CarNames): RacingResults {
        var cars: Cars = Cars.initCars(carNames = carNames)
        var racingResults = RacingResults()
        (1..rounds.value).forEach() { round ->
            val refuels = RandomGasStation.refuels(cars.size())
            cars = cars.moveForwardAll(refuels = refuels)
            racingResults = racingResults.add(RacingResult.of(round = round, cars = cars))
        }
        return racingResults
    }
}
