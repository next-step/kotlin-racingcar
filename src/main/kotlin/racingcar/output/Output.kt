package racingcar.output

interface Output {
    fun numberOfCarsMessage()
    fun finalLab()
    fun labsOfRacingCars(racingLabs: List<Int>)
    fun errorMessage(message: String)
}
