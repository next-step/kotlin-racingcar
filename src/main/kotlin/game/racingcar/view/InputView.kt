package game.racingcar.view

interface InputView {
    var carNames: List<String>
    var numberOfLap: Int
    fun init()

    fun numberOfCar(): Int
}
