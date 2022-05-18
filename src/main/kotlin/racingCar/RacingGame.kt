package racingCar

import racingCar.entity.Car
import racingCar.lib.RandomNumber
import racingCar.lib.UserInputData
import racingCar.ui.ResultView

class RacingGame(val userInput: UserInputData) {
    fun play() {
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
