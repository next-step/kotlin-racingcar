package racingcar.model

interface Car {
    fun getTrack(): String
    fun goForward()
    fun copy(): Car
}
