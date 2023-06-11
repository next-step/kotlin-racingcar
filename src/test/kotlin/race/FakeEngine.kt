package race

import race.model.Engine

class FakeEngine(private val power: Int) : Engine {
    override fun cycle() = power
}
