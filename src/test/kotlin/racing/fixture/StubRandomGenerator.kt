package racing.fixture

import racing.port.RandomGeneratorPort

class StubRandomGenerator(private val value: Int) : RandomGeneratorPort {

    override fun generate(): Int = value
}
