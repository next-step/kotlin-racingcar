package racingcar.view

data class ParticipateCarName(
    val name: String
) {
    init {
        validateName()
    }

    private fun validateName() {
        if (name.length > NAME_MAX_LENGTH) throw IllegalArgumentException("자동차 이름은 최대 5자까지 가능해요.")
    }

    companion object {
        private const val NAME_MAX_LENGTH = 5
    }
}
