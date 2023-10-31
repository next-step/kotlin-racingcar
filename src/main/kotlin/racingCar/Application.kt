package racingCar

import racingCar.domain.Car
import racingCar.domain.CarCount
import racingCar.domain.Cars
import racingCar.domain.Race
import racingCar.domain.TryCount
import racingCar.ui.InputView
import racingCar.ui.RaceResultStorage
import racingCar.ui.ResultView
import racingCar.util.CarPowerGenerator

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
