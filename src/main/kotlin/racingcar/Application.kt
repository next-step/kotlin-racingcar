package racingcar

import racingcar.domain.Car
import racingcar.domain.CarCount
import racingcar.domain.Cars
import racingcar.domain.Race
import racingcar.domain.TryCount
import racingcar.ui.InputView
import racingcar.ui.RaceResultStorage
import racingcar.ui.ResultView
import racingcar.util.CarPowerGenerator

class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val carCount = InputView.readCarCount()
            val tryCount = InputView.readTryCount()

            val cars = makeCars(carCount)
            val race = makeRace(tryCount, cars)

            ResultView.printResultMessage()
            race.start()
        }

        private fun makeCars(carCount: CarCount): Cars {
            return Cars(
                cars = List(carCount.value) { Car() },
                numberGenerator = CarPowerGenerator
            )
        }

        private fun makeRace(tryCount: TryCount, cars: Cars): Race {
            return Race(
                tryCount = tryCount,
                cars = cars,
                raceResult = RaceResultStorage()
            )
        }
    }
}
