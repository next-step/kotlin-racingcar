package domain.step4.domain.racingcar

@JvmInline
value class Name(private val name: String) {
    init {
        require(name.isNotBlank()) { "이름은 비어있서는 안 됩니다." }
        require(name.length <= 5) { "이름의 길이는 5를 초과해서는 안 됩니다." }
    }
}