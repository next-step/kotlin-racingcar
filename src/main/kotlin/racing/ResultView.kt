package racing

fun printResult(cars: List<Car>, tryCount: Int) {
    repeat(tryCount) { index ->
        printRecord(cars, index)
        println()
    }
}

fun printRecord(cars: List<Car>, index: Int) {
    cars.forEach { car ->
        println("${car.name} : " + "-".repeat(car.getRecordByIndex(index)))
    }
}

fun printWinner(carRacing: CarRacing) {
    val winners = carRacing.getWinner().joinToString(", ") { it.name }
    println("${winners}가 최종 우승했습니다.")
}
