package racingCar

const val RANDOM_LIMIT_NUM = 10

class RacingCar(private val carNames: List<String>) {

    companion object {
        val carsInRacing = mutableListOf<Car>()
    }

    init {
        generateCar(carNames)
    }

    private fun generateCar(carNames: List<String>) {
        repeat(carNames.size) { index ->
            carsInRacing.add(Car(carNames[index]))
        }
    }

    fun carMove(trialCount: Int): List<Car> {
        var randomNum: Int
        repeat(trialCount) { index ->
            println("${index + 1} 번째 경주")
            for (car in carsInRacing) {

                randomNum = RandomGenerator.getRandomNumber()
                car.changeStateRacingCar(randomNum)
            }
            OutputView.getCarRacingResult(carsInRacing)
        }
        return carsInRacing
    }
}

fun main() {
    val carNames = InputView.getCarName()
    val trialCount = InputView.getTrialCount()
    val racing = RacingCar(carNames)
    val resultRacingCar = racing.run { racing.carMove(trialCount) }
    val returnWinner = Winner.getRacingWinner(resultRacingCar)
    OutputView.getCarRacingWinners(returnWinner)
}
