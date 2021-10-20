package domain.step4.domain.racingcar

class Name(private val name: String) {
    init {
        require(name.length <= 5) { "이름의 길이는 5를 초과해서는 안 됩니다." }
    }
}