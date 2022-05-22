package racingcar

object RaceHost {

    fun play(rounds: Rounds, numberOfParticipants: NumberOfParticipants): RacingResults {
        var cars: Cars = Cars.initCars(numberOfParticipants.value)
        var racingResults = RacingResults()
        (1..rounds.value).forEach() { round ->
            val refuels = RandomGasStation.refuels(numberOfParticipants.value)
            cars = cars.moveForwardAll(refuels = refuels)
            racingResults = racingResults.add(RacingResult.of(round = round, cars = cars))
        }
        return racingResults
    }
}
