package racingcar

class RandomDriveCar(
    override val carNumber: Long,
    override val name: String,
    private val randomNumberGenerator: RandomNumberGenerator,
    private val minDriveRandomNumber: Long
) : Car {

    override var position: Long = 0
        private set
    override fun drive() {
        if (isDrive()) {
            position += 1
        }
    }

    private fun isDrive(): Boolean {
        return randomNumberGenerator.generate() >= minDriveRandomNumber
    }
}
