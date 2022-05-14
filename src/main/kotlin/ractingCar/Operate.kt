package ractingCar

import ractingCar.entity.Car
import ractingCar.ui.InputView
import ractingCar.ui.ResultView

class Operate {
    fun play() {
        val userInput = InputView().getInput()

        // todo makeCarList 분리
        val carList = arrayListOf<Car>()
        for (i in 1..userInput[0]) {
            carList.add(Car())
        }

        for (i in 1..userInput[1]) {
            carList.forEach {
                it.move()
            }
            ResultView().getResult(carList)
        }
    }
}