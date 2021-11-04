package racingcar.view

const val SEPARATOR = ", "
const val CAR_CHARACTER = "-"

fun printCurrentPosition(name: String, position: Int) {
    println("$name : ${CAR_CHARACTER.repeat(position)}")
}

fun showWinners(winners: List<String>) {
    print("${winners.joinToString(SEPARATOR) { it }}가 최종 우승했습니다.")
}
