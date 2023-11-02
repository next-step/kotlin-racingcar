package carRace

sealed interface CarsProvider {

    fun provide(): CarSpecs

    class Manual(private val carNames: List<String>, private val iterationCount: Int) : CarsProvider {
        override fun provide(): CarSpecs = CarSpecs(carNames, iterationCount)
    }

    object UserInput : CarsProvider {
        override fun provide(): CarSpecs {
            val carList = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").run {
                readln()
                    .trim()
                    .split(",")
                    .map { it.trim() }
            }
            val iterationCount = println("시도할 횟수는 몇 회인가요?").run { readln().trim().toInt() }
            return CarSpecs(carList, iterationCount)
        }
    }
}
