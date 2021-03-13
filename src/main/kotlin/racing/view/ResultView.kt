package racing.view

fun printResult(recordsPerCarName: Map<String, List<Int>>, tryCount: Int) {
    repeat(tryCount) { index ->
        printRecord(recordsPerCarName.map { Pair(it.key, it.value[index]) })
        println()
    }
}

fun printRecord(recordPerCarName: List<Pair<String, Int>>) {
    recordPerCarName.forEach {
        println("${it.first} : ${"-".repeat(it.second)}")
    }
}

fun printWinner(winners: String) {
    println("${winners}가 최종 우승했습니다.")
}
