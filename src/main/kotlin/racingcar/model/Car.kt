package racingcar.model

interface Car {
    val track: String
    fun goForward(): Car
}
