package racing.components

class RandomWrapperTestImpl(private val returnValue: Int? = null) : RandomWrapper {
    override fun nextInt(until: Int) = returnValue ?: until - 1
}
