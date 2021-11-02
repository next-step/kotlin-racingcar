package racingcar

const val CAR_CHARACTER = "-"

fun printCurrentPosition(name: String, position: Int) {
    println("$name : ${CAR_CHARACTER.repeat(position)}")
}

fun showWinners(winners: List<Car>) {
    print("${winners.joinToString(SEPARATOR) { it.name }}가 최종 우승했습니다.")
}
