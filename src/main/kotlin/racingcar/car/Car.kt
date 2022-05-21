package racingcar.car

interface Car {
    fun name(): String
    fun forward(): Car
    fun position(): Position
}
