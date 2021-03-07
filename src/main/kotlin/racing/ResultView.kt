package racing

fun printResult(cars: List<Car>, tryCount: Int) {
    repeat(tryCount) { index ->
        cars.forEach { car ->
            println("-".repeat(car.records[index]))
        }
        println()
    }
}
