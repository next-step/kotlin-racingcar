package step3.domain.race

import step3.domain.car.CarStatus

data class RaceRoundResult(val carStatuses: Map<Int, CarStatus>) {

    fun getCarStatus(carId: Int): CarStatus {
        return carStatuses[carId] ?: throw IllegalArgumentException("id not exist")
    }
}
