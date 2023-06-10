package step3.domain.race

import step3.domain.car.CarStatus

data class RaceRoundResult(val carStatusList: List<CarStatus>) {

    fun getCarStatusCount(): Int = carStatusList.size

    fun getCarStatus(carStatusIndex: Int): CarStatus {
        require(carStatusIndex >= 0 && carStatusIndex < getCarStatusCount())
        return carStatusList[carStatusIndex]
    }
}
