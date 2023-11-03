package racing

import racing.domain.CarRacing
import racing.domain.CarRacingRecordStrategy
import racing.domain.CarRacingRecorder
import racing.domain.CarRepository
import racing.domain.CarRepositoryImpl
import racing.view.InputView
import racing.view.ResultView

class CarRacingApplication {
    companion object {
        private val repository: CarRepository = CarRepositoryImpl
        private val recorder: CarRacingRecordStrategy = CarRacingRecorder

        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val result = CarRacing(repository, recorder).race(carNames, tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
