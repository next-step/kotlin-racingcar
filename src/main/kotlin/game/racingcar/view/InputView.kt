package game.racingcar.view

interface InputView {
    fun init() {}

    fun carNames(): List<String>

    fun numberOfLap(): Int
}
