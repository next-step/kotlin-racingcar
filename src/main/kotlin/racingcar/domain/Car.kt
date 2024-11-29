package racingcar.domain

data class Car(
    val name: String,
    val position: Int = INITIAL_POSITION,
) : Comparable<Car> {
    init {
        require(name.length <= MAXIMUM_NAME_LENGTH) { "자동차 이름은 ${MAXIMUM_NAME_LENGTH}자를 초과할 수 없습니다." }
    }

    fun moveIfPossible(isAdvancePossible: Boolean): Car =
        if (isAdvancePossible) {
            copy(position = this.position + 1)
        } else {
            this
        }

    fun isSamePosition(other: Car) = this.position == other.position

    override fun compareTo(other: Car) = this.position - other.position

    companion object {
        private const val INITIAL_POSITION = 0
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}
