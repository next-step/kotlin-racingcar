package racingcar

object RaceHost {

    fun play(rounds: Int, numberOfParticipants: Int): RacingResults {
        var cars: Cars = Cars.initCars(numberOfParticipants)
        var racingResults = RacingResults()
        repeat(rounds) {
            cars = cars.move(RandomGasStation.refuels(numberOfParticipants))
            racingResults = racingResults.add(RacingResult.of(round = it, cars = cars))
        }
        return racingResults
    }
}
