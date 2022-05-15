package racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carNumberInput = readln().inputConverter()

    println("시도할 횟수는 몇 회인가요?")
    val turnNumberInput = readln().inputConverter()

    val game = Game()
    game.run(carNumberInput, turnNumberInput)
    game.clearResult()
}

fun String.inputConverter(): Int {
    return this
        .validateForm()
        .validateRange()
}

fun String.validateForm(): Int {
    return this.toIntOrNull() ?: throw IllegalArgumentException("올바른 입력값의 형식이 아닙니다")
}

fun Int.validateRange(): Int {
    require(this > 0) { "입력값의 범위는 1 이상입니다" }
    return this
}
