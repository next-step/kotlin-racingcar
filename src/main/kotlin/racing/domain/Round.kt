package racing.domain

import racing.dto.RoundInfo

class Round(
    val id: Int,
    val cars: List<RacingCar>
) {
    fun race(): RoundInfo {
        val carInfos = cars.map {
            it.moveForward()
            it.mapToRacingCarInfo()
        }

        return RoundInfo(id, carInfos)
    }
}
