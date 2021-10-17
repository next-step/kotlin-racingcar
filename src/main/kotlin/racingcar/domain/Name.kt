package racingcar.domain

data class Name(val name: String?) {
    init {
        require(!name.isNullOrBlank()) { BLANK_NOT_ALLOWED }
        require(name.length <= MAXIMUM_NAME_LENGTH) { NAME_LENGTH_EXCEED }
    }

    companion object {
        const val BLANK_NOT_ALLOWED = "이름에 빈 값이 들어갈 수 없습니다"
        const val NAME_LENGTH_EXCEED = "이름이 5자보다 클 수 없습니다"
        const val MAXIMUM_NAME_LENGTH = 5
    }

    override fun toString(): String {
        return name.toString()
    }
}
