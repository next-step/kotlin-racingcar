package racingcar.view

private const val RESULT_TITLE = "실행 결과"
private const val POSITION = "-"

fun printResultTitle() = println(RESULT_TITLE)

fun printCurrentResult(carPositions: List<Pair<String, Int>>) {
    carPositions.forEach { println("${it.first} : ${POSITION.repeat(it.second)}") }
    println()
}
