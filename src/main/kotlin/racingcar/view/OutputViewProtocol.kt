package racingcar.view

import racingcar.dto.RaceWinner

interface OutputViewProtocol {
    fun printCar(name: String, location: Int)

    fun printRaceWinner(raceResult: RaceWinner)

    fun printNextLine()
}
