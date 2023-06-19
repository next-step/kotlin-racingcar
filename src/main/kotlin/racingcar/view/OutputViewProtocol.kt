package racingcar.view

import racingcar.dto.RaceResult

interface OutputViewProtocol {
    fun printCar(name: String, location: Int)

    fun printRaceWinner(raceResult: RaceResult)

    fun printNextLine()
}
