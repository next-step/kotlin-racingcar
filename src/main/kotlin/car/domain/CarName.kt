package car.domain

data class CarName(private val name: String) {
    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) { "이름의 길이는 $MAXIMUM_NAME_LENGTH 이하여야 합니다." }
    }

    override fun toString(): String = name

    companion object {
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}
