package racingcar.view.output

import racingcar.dto.RacingRecord

interface Output {
    fun numberOfCarsNames()
    fun numberOfCarsMessage()
    fun finalLab()
    fun errorMessage(message: String)
    fun racingRecords(racingRecords: List<RacingRecord>)
    fun winnersNames(gameWinnersNames: List<String>)
}
