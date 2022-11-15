package racingcar

interface Car {
    val name: Name
    val position: Position
    fun move(power: Int)
}
