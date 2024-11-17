package racingcar

class FixedNumberGenerator(val fixedNumber: Int) : NumberGenerator {
    override fun generate(): Int {
        return fixedNumber
    }
}
