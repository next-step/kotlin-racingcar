package racing.processor

import racing.model.CarRacing
import racing.reader.CarRacingReader
import racing.viewer.CarRacingViewer
import kotlin.random.Random

class CarRacingProcessor(
    private val carRacingViewer: CarRacingViewer,
    private val carRacingReader: CarRacingReader
) {

    private val random = Random(System.currentTimeMillis())

    fun play() {
        val racingCars = setRacingCars()

        carRacingViewer.showHowManyTries()
        val numberOfTry = carRacingReader.readNumberOfTry()

        moveCarsAndShowStatus(numberOfTry, racingCars)
    }

    private fun setRacingCars(): Array<CarRacing> {
        carRacingViewer.showHowManyCars()
        val numberOfCars = carRacingReader.readNumberOfCar()

        return Array(numberOfCars) { index -> CarRacing(index, 0) }
    }

    private fun moveCarsAndShowStatus(numberOfTry: Int, racingCars: Array<CarRacing>) {
        (0..numberOfTry).forEach { _ ->
            racingCars.filter { random.nextInt() % 10 > 4 }
                .forEach { it.movePosition(it.position + 1) }
            carRacingViewer.showGameStatus(racingCars)
        }
    }
}
