package racingcar.domain

@JvmInline
value class Name(private val name: String) {
    fun getName() = name

    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) { "이름은 10자 이하여야 합니다." }
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH = 10
    }
}
