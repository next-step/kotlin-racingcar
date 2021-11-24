package racingcar.communication.output

import racingcar.dto.RacingRecord

interface Output {
    fun numberOfCarsNames()
    fun numberOfCarsMessage()
    fun finalLab()
    fun errorMessage(message: String)
    fun racingCarNameAndRecord(racingCars: List<RacingRecord>)
    fun labsOfRacingCars(racingLabs: List<Int>)
}
