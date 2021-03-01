package racing.domain.random

class TestRandomWrapper(private val returnValue: Int) : RandomWrapper {
    override fun nextInt(until: Int) = returnValue
}
