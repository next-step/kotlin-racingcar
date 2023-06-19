package study.racing.car.factory

import study.racing.car.CarList

fun interface CarListFactory {
    fun create(): CarList
}
