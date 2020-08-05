package racingcar.strategy

interface Strategy {
    fun move(number: Int): Boolean
    fun generateNumber(): Int
}
