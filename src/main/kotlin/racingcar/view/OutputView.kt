package racingcar.view

private const val RESULT_TITLE = "실행 결과"
private const val POSITION = "-"

fun printResultTitle() = println(RESULT_TITLE)

fun printCurrentResult(positions: List<Int>) {
    positions.forEach { println(POSITION.repeat(it)) }
    println()
}
