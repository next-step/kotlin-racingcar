package racing.view

fun printResult(recordsPerCarName: Map<String, List<Int>>, tryCount: Int) {
    repeat(tryCount) { index ->
        printRecord(recordsPerCarName.map { CarRecord(it.key, it.value[index]) })
        println()
    }
}

fun printRecord(recordPerCarName: List<CarRecord>) {
    recordPerCarName.forEach {
        println("${it.name} : ${"-".repeat(it.position)}")
    }
}

fun printWinner(winners: String) {
    println("${winners}가 최종 우승했습니다.")
}
