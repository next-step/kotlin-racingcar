package racing

import racing.domain.Car
import racing.domain.CarFactory
import racing.domain.CarFactoryImpl
import racing.domain.CarRacing
import racing.domain.CarRacingRecordStrategy
import racing.domain.CarRacingRecorder
import racing.domain.NumberStrategy
import racing.domain.RandomNumberStrategy
import racing.view.InputView
import racing.view.ResultView

class CarRacingApplication {
    companion object {
        private val carFactory: CarFactory = CarFactoryImpl
        private val numberStrategy: NumberStrategy = RandomNumberStrategy
        private val recorder: CarRacingRecordStrategy = CarRacingRecorder

        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val cars = carFactory.createCars(carNames)
            val result = CarRacing(numberStrategy, recorder, cars).race(tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
