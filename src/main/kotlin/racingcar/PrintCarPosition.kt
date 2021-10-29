package racingcar

const val CAR_CHARACTER = '-'

fun printDefaultPosition() {
    println(CAR_CHARACTER)
}

fun printCurrentPosition(position: Int) {
    repeat(position) {
        print(CAR_CHARACTER)
    }
    println()
}
