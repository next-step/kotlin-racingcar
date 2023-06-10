package next.step.racing.domain.car

data class CarName(val name: String) {
    init {
        require(name.isNotBlank()) { "차 이름은 공백이 아니어야 합니다." }
        require(name.length <= 5) { "차 이름은 5자 이하여야 합니다." }
    }
}
