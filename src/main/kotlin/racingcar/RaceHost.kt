package racingcar

object RaceHost {

    fun play(rounds: Rounds, numberOfParticipants: Int): RacingResults {
        var cars: Cars = Cars.initCars(numberOfParticipants)
        var racingResults = RacingResults()
        repeat(rounds.value) {
            cars = cars.move(RandomGasStation.refuels(numberOfParticipants))
            racingResults = racingResults.add(RacingResult.of(round = it + 1, cars = cars))
        }
        return racingResults
    }
}
