package racingCar2

class FixedNumberGenerator(
    private val fixedNumber: Int
) : NumberGenerator {
    override fun getRandomNumber(): Int {
        return fixedNumber
    }
}
