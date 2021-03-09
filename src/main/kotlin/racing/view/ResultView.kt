package racing

import racing.domain.Car

fun printResult(recordsPerCarName: Map<String, List<Int>>, tryCount: Int) {
    repeat(tryCount) { index ->
        printRecord(recordsPerCarName, index)
        println()
    }
}

fun printRecord(recordsPerCarName: Map<String, List<Int>>, index: Int) {
    recordsPerCarName.forEach { recordOfCar ->
        println("${recordOfCar.key} : ${"-".repeat(recordOfCar.value[index])}")
    }
}

fun printWinner(winners: List<Car>) {
    println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
}
