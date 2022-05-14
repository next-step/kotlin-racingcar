package ractingCar.ui

import ractingCar.entity.Car

class ResultView {
    fun getResult(carList: List<Car>) {
        for (car in carList) {
            car.printMoves()
        }
        println()
    }
}