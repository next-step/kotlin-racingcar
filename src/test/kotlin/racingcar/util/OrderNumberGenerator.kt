package racingcar.util

class OrderNumberGenerator(private vararg val numbers: Int) : NumberGenerator {
    private var index = 0

    override fun getNumber(): Int {
        return numbers[index++ % numbers.size]
    }
}
