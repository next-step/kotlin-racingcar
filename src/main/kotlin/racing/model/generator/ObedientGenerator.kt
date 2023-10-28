package racing.model.generator

class ObedientGenerator(
    private val value: Int,
) : Generator {
    override fun generate(): Int {
        return value
    }
}
