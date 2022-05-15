package racingCar

import racingCar.entity.Car
import racingCar.lib.RandomNumber
import racingCar.ui.InputView
import racingCar.ui.ResultView

class RacingGame {
    fun play() {
        val userInput = InputView().getInput()

        // todo List 와 ArrayList의 차이
        // makeCarList 함수 분리 대신 함수형 내장 매서드 사용
        val carList: List<Car> = List(userInput.numOfCars) { Car() }

        repeat(userInput.numOfMoves) {
            carList.forEach {
                val rand = RandomNumber().getOneDigitRandomNum()
                it.move(rand)
            }
            ResultView().printAllCarMoves(carList)
        }
    }
}
