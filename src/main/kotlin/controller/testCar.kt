package controller

import domain.Car
import java.util.*

class testCar {
    fun testCar2() {
        val numCar = 10
        val cars = ArrayList<Car>()
        for (i in 0 until numCar) {
            cars.add(Car(Integer.toString(i), 0))
        }
        println(cars)
    }
}