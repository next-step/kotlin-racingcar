package racingcar.application

interface MessagePrinter {
    fun printCarNameQuestion()

    fun printMoveAttemptCountQuestion()

    fun printResultMessage()

    fun printRaceResultMessage(raceResults: RaceResults)

    fun printWinners(winners: Winners)
}
