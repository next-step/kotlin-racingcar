package racingcar.model

fun interface MovingStrategy {
    fun forwardMovable(number: Int): Boolean
}
