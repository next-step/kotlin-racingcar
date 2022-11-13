package study.racing

class FakePowerSource(
    private val power: Int
) : PowerSource {
    override fun getPower(): Int = power
}