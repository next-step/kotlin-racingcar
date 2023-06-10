package com.racing.step3.service

import com.racing.step3.domain.Car

object CarGameService {
    fun createCarList(num: Int): List<Car> {
        return buildList(num) {
            repeat(num) { add(Car()) }
        }
    }

    fun moveCar(carList: List<Car>, moveCarStrategy: () -> Int): List<Car> {
        return carList.map {
            it.move { moveCarStrategy() }
        }.toList()
    }
}
