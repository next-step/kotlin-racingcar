package racingcar.domain

data class RoundHistory(
    val round: Int,
    val carInfos: List<CarInfo>,
) {
    fun maxPositionCarInfos(): List<CarInfo> {
        val maxPosition = carInfos.maxOf { it.position }

        return carInfos.filter { it.position == maxPosition }
            .toList()
    }
}
