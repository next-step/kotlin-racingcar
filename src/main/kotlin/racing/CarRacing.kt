package racing

fun main() {
    val carCount = inputCarCount()
    val tryCount = inputTryCount()

    val carRacing = CarRacing()
    carRacing.execute(carCount, tryCount)

    println("실행 결과")
    carRacing.records.forEach {
        printResult(it)
    }
}

class CarRacing(private val cars: List<Car>, private val tryCount: Int) {
    val records = ArrayList<Record>()

    fun execute() {
        repeat(tryCount) {
            val record = Record(
                cars.map {
                    it.tryGo()
                    it.position
                }
            )
            records.add(record)
        }
    }
}
