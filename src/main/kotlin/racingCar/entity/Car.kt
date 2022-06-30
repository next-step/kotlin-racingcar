package racingCar.entity

interface Car {
    val name: String
    val distance: Int
    fun move(randNumber: Int): Car
}
