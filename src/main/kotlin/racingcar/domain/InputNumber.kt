package racingcar.domain

class InputNumber(input: String) {
    val number: Int
    init {
        number = input.toInt()
    }
}
