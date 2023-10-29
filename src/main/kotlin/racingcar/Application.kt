package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Race
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

        private fun makeCars(carCount: Int): Cars {
            return Cars(
                cars = List(carCount) { Car() },
                numberGenerator = CarPowerGenerator
            )
        }

        private fun makeRace(tryCount: Int, cars: Cars): Race {
            return Race(
                tryCount = tryCount,
                cars = cars,
                raceResult = RaceResultStorage()
            )
        }
    }
}
