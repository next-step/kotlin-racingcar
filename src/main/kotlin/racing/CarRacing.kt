package racing

fun main() {
    val carNameLine = inputCarName()
    val tryCount = inputTryCount()
    val carNames = CarNameParser().parse(carNameLine)

    val cars = carNames.map { Car(it) }
    val carRacing = CarRacing(cars, tryCount)
    carRacing.execute()

    println("실행 결과")
    val recordsPerCarName = cars.associateBy({ it.name }, { it.getRecords() })
    printResult(recordsPerCarName, tryCount)
    printWinner(carRacing.getWinner())
}

class CarRacing(private val cars: List<Car>, private val tryCount: Int) {

    fun execute() {
        repeat(tryCount) {
            executeCarGo()
        }
    }

    private fun executeCarGo() {
        cars.forEach {
            it.tryGo()
        }
    }

    fun getWinner(): List<Car> {
        val maxPosition = cars.map { it.position }.max()
        require(maxPosition != null) { "car name이 입력되었다면, maxPosition은 null이 될수 없습니다." }

        return cars.filter { it.position == maxPosition }
    }
}
