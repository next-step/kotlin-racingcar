package racingcar.domain

private const val START_POSITION = 0
private const val MOVE_FORWARD_START_NUM = 4
private const val MOVE_FORWARD_COUNT = 1
private const val NAME_LENGTH_LIMIT = 5

data class RacingCar(
    val name: String,
    val position: Int = START_POSITION
) {

    init {
        require(name.length <= NAME_LENGTH_LIMIT) { "$name : 자동차 이름은 ${NAME_LENGTH_LIMIT}글자를 초과하여 입력할 수 없습니다." }
        require(name.isNotBlank()) { "$name : 자동차 이름은 공백을 입력할 수 없습니다." }
    }

    fun moveOrStop(checkNum: Int): RacingCar {
        if (checkNum >= MOVE_FORWARD_START_NUM) {
            return copy(position = this.position + MOVE_FORWARD_COUNT)
        }
        return copy(position = position)
    }
}
