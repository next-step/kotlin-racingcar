package _3_racing_car.domain.power

abstract class Power {
    abstract fun create(from: Int = 0, until: Int = 9): Int
}
