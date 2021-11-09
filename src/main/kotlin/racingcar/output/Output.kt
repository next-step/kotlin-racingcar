package racingcar.output

interface Output {
    fun numberOfCarsMessage()
    fun tryTimesOfRace()
    fun positionOfCar(currentPosition: Int)
    fun emptyLine()
    fun errorMessage(message: String)
}
