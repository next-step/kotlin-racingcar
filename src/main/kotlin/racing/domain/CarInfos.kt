package racing.domain

data class CarInfos(val carInfoList: List<CarInfo>) {
    fun findMaxPosition(): Position =
        carInfoList.reduce { carInfo1, carInfo2 -> CarInfo.max(carInfo1, carInfo2) }.position

}
