package racingcar

const val CAR_CHARACTER = "-"

fun printCurrentPosition(name: String, position: Int) {
    println("$name : ${CAR_CHARACTER.repeat(position)}")
}
