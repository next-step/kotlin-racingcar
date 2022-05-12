package racingcar

fun main() {

    val carCount: String? = readLine()
    require(!carCount.isNullOrBlank()) { IllegalArgumentException("잘못된 요청 입니다.") }

    val roundCount: String? = readLine()
    require(!roundCount.isNullOrBlank()) { IllegalArgumentException("잘못된 요청 입니다.") }

    val readyCars = ready(carCount.toInt())

    val racing = Racing(Cars(readyCars))
    racing.start(roundCount.toInt(), DefaultMoveStrategy())

    val result = racing.result()

    result.forEach {
        it.cars.forEach { car ->
            println(car.position)
        }
        println("----------------")
    }
}

fun ready(carCount: Int): List<Car> {
    val initCars = mutableListOf<Car>()
    for (i in 0 until carCount) {
        initCars.add(Car())
    }
    return initCars
}
