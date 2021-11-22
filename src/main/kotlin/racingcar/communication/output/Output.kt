package racingcar.communication.output

interface Output {
    fun numberOfCarsMessage()
    fun finalLab()
    fun errorMessage(message: String)
    fun labsOfRacingCars(racingLabs: List<Int>)
}
