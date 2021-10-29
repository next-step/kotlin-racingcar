package racingcar

const val CAR_CHARACTER = '-'

fun printDefaultPosition() {
    println(CAR_CHARACTER)
}

fun printCurrentPosition(position: Int) {
    println("-".repeat(position))
    println()
}
