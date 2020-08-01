package racingCar

import kotlin.random.Random

const val RANDOM_LIMIT_NUM = 10

class RacingCar(private val carCount: Int) {

    private val carsInRacing = ArrayList<Car>()

    init {
        generateCar(carCount)
    }

    private fun generateCar(carCount: Int) {
        for (car in 0 until carCount) {
            carsInRacing.add(Car())
        }
    }

    fun carMove(trialCount: Int) {
        var randomNum: Int
        for (i in 0 until trialCount) {
            println("--------------------------")
            println("${i + 1}번째 시도!")
            for (car in carsInRacing) {
                randomNum = RandomGenerator.getRandomNumber()
                car.changeStateRacingCar(randomNum)
            }
            OutputView.getCarRacingResult(carsInRacing)
        }
    }
}

object RandomGenerator {
    fun getRandomNumber(): Int {
        return Random.nextInt(RANDOM_LIMIT_NUM)
    }
}

fun main() {
    val carCount = InputView.getCarCount()
    val trialCount = InputView.getTrialCount()
    val racing = RacingCar(carCount)
    racing.run { racing.carMove(trialCount) }
}
