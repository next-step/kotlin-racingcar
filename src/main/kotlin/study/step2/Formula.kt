package study.step2

class Formula(
    input: String?
) {
    val expression: List<String>

    init {
        require(!input.isNullOrBlank()) { "잘못된 연산자입니다." }
        expression = input.split(" ")
    }
}
