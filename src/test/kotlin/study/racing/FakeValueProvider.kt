package study.racing

class FakeValueProvider(
    private val value: String
) : ValueProvider<String?> {
    override fun getValue(): String = value
}