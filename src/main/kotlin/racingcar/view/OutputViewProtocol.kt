package racingcar.view

import racingcar.dto.RaceResult

interface OutputViewProtocol {
    fun printLocation(location: Int)

    fun printName(name: String)

    fun printRaceWinner(raceResult: RaceResult)

    fun printNextLine()
}
