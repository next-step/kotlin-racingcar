package study.racingcar.race

data class CarState(
    val name: String,
    val position: Int
) {
    fun getVisualPosition(): String = "-".repeat(position)

    fun getPositionLength(): Int = position
}
