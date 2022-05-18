package racingcar.model

data class CarName(
    val name: String
) {

    init {
        require(name.length <= 5) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    override fun toString(): String {
        return name
    }
}
