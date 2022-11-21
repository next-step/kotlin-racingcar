package car_race.logic.car

data class CarName(
    val name: String
) {
    init {
        check(name.length <= NAME_MAX_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 ${NAME_MAX_LENGTH}자를 초과할 수 없습니다.")
        }
    }

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}
