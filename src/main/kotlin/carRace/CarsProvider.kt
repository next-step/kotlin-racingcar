package carRace

sealed interface CarsProvider {

    fun provide(): CarSpecs

    class Manual(private val carCount: Int, private val iterationCount: Int) : CarsProvider {
        override fun provide(): CarSpecs = CarSpecs(carCount, iterationCount)
    }

    object UserInput : CarsProvider {
        override fun provide(): CarSpecs {
            val carCount = println("자동차 대수는 몇 대인가요?").run { readln().trim().toInt() }
            val iterationCount = println("시도할 횟수는 몇 회인가요?").run { readln().trim().toInt() }
            return CarSpecs(carCount, iterationCount)
        }
    }
}
