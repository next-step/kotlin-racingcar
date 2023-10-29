package racing.model.generator

class ObedientGenerator(
    private val value: Int,
) : Generator {
    val assertMessage: String = "올바르지 않은 입력 [$value] : 1~9사이의 입력만 허용됩니다"
    override fun generate(): Int {
        require((1 until 10).contains(value)) { assertMessage }
        return value
    }
}
