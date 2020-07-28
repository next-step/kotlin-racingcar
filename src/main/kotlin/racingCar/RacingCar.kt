package racingCar

import kotlin.random.Random

class RacingCar(val carCount: Int) {

    private val carsInRacing = ArrayList<Car>()

    init {
        generateCar(carCount)
    }

    private fun generateCar(carCount: Int) {
        for (car in 0 until carCount) {
            carsInRacing.add(Car())
        }
        print(carsInRacing.size)
    }

    fun carMove(trialCount: Int): List<Car> {
        var randomNum: Int
        for (i in 0 until trialCount) {
            println("--------------------------")
            println("trial count - ${i + 1}")
            for (j in 0 until carCount) {
                randomNum = RandomGenerator.getRandomNumber()
                println("car $j 의 number - $randomNum")
                carsInRacing[j].changeStateRacingCar(randomNum)
            }
        }

        return carsInRacing
    }
}

object RandomGenerator {
    const val RANDOM_LIMIT_NUM = 10

    fun getRandomNumber(): Int {
        return Random.nextInt(RANDOM_LIMIT_NUM)
    }
}

fun main() {
    val carCount = InputView.getCarCount()
    val trialCount = InputView.getTrialCount()

    val racing = RacingCar(carCount)
    val racingCarResult = racing.run { racing.carMove(trialCount) }

    // OutputView.getCarRacingResult(racingCarResult)
}
