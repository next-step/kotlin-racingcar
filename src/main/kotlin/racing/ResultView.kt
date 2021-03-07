package racing

fun printResult(cars: List<Car>, tryCount: Int) {
    repeat(tryCount) { index ->
        printRecord(cars, index)
        println()
    }
}

fun printRecord(cars: List<Car>, index: Int) {
    cars.forEach { car ->
        println("-".repeat(car.records[index]))
    }
}
