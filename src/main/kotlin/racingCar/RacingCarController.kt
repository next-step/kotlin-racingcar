package racingCar

import racingCar.domain.Car
import racingCar.domain.CarNames
import racingCar.domain.Cars
import racingCar.domain.Race
import racingCar.domain.TryCount
import racingCar.ui.InputView
import racingCar.ui.RaceResultStorage
import racingCar.ui.ResultView
import racingCar.util.CarPowerGenerator

class RacingCarController {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val carNames = InputView.readCarNames()
            val tryCount = InputView.readTryCount()

            val cars = makeCars(carNames)
            val raceResultStorage = RaceResultStorage()
            val race = makeRace(tryCount, cars, raceResultStorage)

            race.start()

            ResultView.printRaceResult(race.isFinished, raceResultStorage.getRoundResults())
            ResultView.printWinners(raceResultStorage.getWinners())
        }

        private fun makeCars(carNames: CarNames): Cars {
            return Cars(
                cars = carNames.names.map { Car(name = it) },
                numberGenerator = CarPowerGenerator
            )
        }

        private fun makeRace(tryCount: TryCount, cars: Cars, raceResultStorage: RaceResultStorage): Race {
            return Race(
                tryCount = tryCount,
                cars = cars,
                raceResult = raceResultStorage
            )
        }
    }
}
