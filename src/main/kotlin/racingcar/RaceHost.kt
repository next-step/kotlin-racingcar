package racingcar

object RaceHost {

    fun play(rounds: Int, numberOfParticipants: Int): RacingResults {
        var cars: Cars = Cars.initCars(numberOfParticipants)
        var racingResults = RacingResults()
        for (i in 1 .. rounds) {
            cars = cars.move(RandomGasStation.refuels(numberOfParticipants))
            racingResults = racingResults.add(RacingResult.of(round = i, cars = cars))
        }
        return racingResults
    }
}
