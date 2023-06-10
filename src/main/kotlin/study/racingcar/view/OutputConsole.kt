package study.racingcar.view

import study.racingcar.race.RaceResult

interface OutputConsole {
    fun printRaceResults(raceResults: List<RaceResult>)
    fun printWinners(winners: List<String>)
}
