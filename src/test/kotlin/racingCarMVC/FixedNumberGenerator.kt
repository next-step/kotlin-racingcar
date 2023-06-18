package racingCarMVC

import racingCarMVC.domain.NumberGenerator

class FixedNumberGenerator(
    private val fixedNumber: Int
) : NumberGenerator {
    override fun getRandomNumber(): Int {
        return fixedNumber
    }
}
