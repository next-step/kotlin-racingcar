package racing.domain

class Winners(lastRoundResult: CarInfos) {
    val winners: List<CarInfo>

    init {
        val maxPosition = lastRoundResult.findMaxPosition()
        winners = lastRoundResult.carInfoList.filter { maxPosition == it.position }
    }
}
