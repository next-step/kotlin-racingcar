package study.racing

class RandomPowerSource : PowerSource {

    override fun getPower(): Int = POWER_RANGE.random()

    companion object {
        private val POWER_RANGE = 0..9
    }
}