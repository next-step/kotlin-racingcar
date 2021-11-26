package racingcar.communication.input

interface Input {
    fun racingCarsNames(): List<String>
    fun numberOfRacingCars(): Int
    fun finalLab(): Int
}
