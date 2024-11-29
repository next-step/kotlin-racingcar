package racingcar.domain

data class RaceHistory(
    val cars: List<Car>,
) {
    fun findMaxPositionCarNames(): List<String> {
        val maxPositionCar = findMaxPositionCar()

        return findSamePositionCar(maxPositionCar)
    }

    private fun findMaxPositionCar(): Car {
        return cars.maxOrNull() ?: throw IllegalArgumentException("차량 리스트가 비었습니다.")
    }

    private fun findSamePositionCar(maxPositionCar: Car): List<String> {
        return cars.filter(maxPositionCar::isSamePosition)
            .map { it.name }
    }
}
