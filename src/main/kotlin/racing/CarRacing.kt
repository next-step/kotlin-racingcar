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

class CarRacing {
    val records = ArrayList<Record>()

    fun execute(carCount: Int, tryCount: Int) {
        val cars = (1..carCount).map { Car(Probability()) }

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
