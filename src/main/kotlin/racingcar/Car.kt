package racingcar

class Car(
    val lineNumber: Int,
    var position: Int = 0
) {

    fun drive() {
        if (CarRandomGenerator.canGo()) position++
    }

    fun printPosition() {
        repeat(position) { print("-") }
        println()
    }
}
