package study.racingcar.domain

data class CarName(val name: String) {
    init {
        require(name.isNotBlank() && name.length <= 5) { "자동차 이름은 1자 이상 5자 이하이어야 합니다." }
    }
}
