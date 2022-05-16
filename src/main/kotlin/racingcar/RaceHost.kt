package racingcar

object RaceHost {

    fun play(rounds: Rounds, numberOfParticipants: NumberOfParticipants): RacingResults {
        var cars: Cars = Cars.initCars(numberOfParticipants.value)
        var racingResults = RacingResults()
        repeat(rounds.value) {
            cars = cars.move(RandomGasStation.refuels(numberOfParticipants.value))
            racingResults = racingResults.add(RacingResult.of(round = it + 1, cars = cars))
        }
        return racingResults
    }
}
