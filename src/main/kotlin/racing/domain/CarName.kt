package racing.domain

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length < 5) {
            "자동차 이름은 5자 이상될 수 없습니다."
        }
    }
}
