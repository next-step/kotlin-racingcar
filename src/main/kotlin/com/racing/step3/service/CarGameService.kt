package com.racing.step3.service

import com.racing.step3.Car
import kotlin.random.Random

object CarGameService {
    fun createCarList(num: Int): List<Car> {
        return (1..num).map {
            Car()
        }
    }

    fun moveCar(carList: List<Car>): List<Car> {
        return carList.map {
            car ->
            car.move { Random.nextInt(10) }
        }.toList()
    }
}
