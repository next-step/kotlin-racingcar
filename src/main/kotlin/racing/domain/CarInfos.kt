package racing.domain

class CarInfos(val carInfoList: List<CarInfo>) {
    fun findMaxPosition() =
        carInfoList.reduce { carInfo1, carInfo2 -> carInfo1.max(carInfo2) }.position
    
}
