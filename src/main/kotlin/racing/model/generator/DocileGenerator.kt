package racing.model.generator

class DocileGenerator(
    private val value: Int,
) : Generator {
    override fun generate(): Int {
        return value
    }
}
