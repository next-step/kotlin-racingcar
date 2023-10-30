package racingcar

class FixedPowerGenerator(private val result: Int) : PowerGenerator {
    override fun generate(): Int {
        return result
    }
}
