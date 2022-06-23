
package racingCar.entity

interface Car {
    val distance: Int
    fun move(randNumber: Int): Car
}