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

        // todo: 더 나은 iterte 방법
        var cnt = 0
        while (true) {
            if (cnt == userInput[1]) break
            cnt++
            carList.forEach {
                it.move()
            }
            ResultView().getResult(carList)
        }
    }
}