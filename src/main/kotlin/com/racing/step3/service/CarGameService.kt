package com.racing.step3.service

import com.racing.step3.domain.Car
import kotlin.random.Random

object CarGameService {
    fun createCarList(num: Int): List<Car> {
        return buildList(num) {
            for (i in 1..num) add(Car())
        }
    }

    fun moveCar(carList: List<Car>): List<Car> {
        return carList.map {
            it.move { Random.nextInt(10) }
        }.toList()
    }
}
