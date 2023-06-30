package racingcar.domain

class RaceWinnersExtractor {

    fun extractWinners(history: RaceHistory): Cars {
        val carsAfterRace = history.history.last()
        return carsAfterRace.getWinners()
    }
}
