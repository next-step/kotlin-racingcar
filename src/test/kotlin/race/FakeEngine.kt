package race

import race.model.Engine

class FakeEngine(private val power: Int) : Engine {
    companion object {
        const val LOW_CYCLE = 1
        const val HIGH_CYCLE = 10
    }
    override fun cycle() = power
}
