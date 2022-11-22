package study.racing

import study.racing.data.PowerSource

class FakePowerSource(
    private val power: Int
) : PowerSource {
    override fun getPower(): Int = power
}