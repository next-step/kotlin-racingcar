package racing.domain

class CarName(
    val name: String?
) {

    private val maxNameLength = 5

    init {
        nameLengthValidation()
    }

    private fun nameLengthValidation() {
        require(name?.length!! <= maxNameLength) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }
}
