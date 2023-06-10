package race

import race.model.Engine

class EngineTest(private val power: Int) : Engine {
    override fun create() = power
}
