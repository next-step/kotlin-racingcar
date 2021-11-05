package racingcar.view

const val SEPARATOR = ", "
const val CAR_CHARACTER = "-"

fun printCurrentPosition(carMap: Map<String, Int>) {
    carMap.forEach {
        println("${it.key} : ${CAR_CHARACTER.repeat(it.value)}")
    }
}

fun showWinners(winners: List<String>) {
    print("${winners.joinToString(SEPARATOR) { it }}가 최종 우승했습니다.")
}
