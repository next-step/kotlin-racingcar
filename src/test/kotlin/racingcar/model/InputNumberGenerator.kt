package racingcar.model

class InputNumberGenerator(private val input: Int) : NumberGenerator {
    override fun getNumber() = input
}
