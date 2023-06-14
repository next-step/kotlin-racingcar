package study.racing.car.factory

import study.racing.car.Car

fun interface CarFactory {
    fun create(): List<Car>
}
