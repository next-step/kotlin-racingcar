package racing.domain

class Winners(lastRoundResult: CarInfos) {
    val winners: List<CarInfo> = getWinner(lastRoundResult)

    companion object {
        private fun getWinner(lastRoundResult: CarInfos): List<CarInfo> {
            val maxPosition = lastRoundResult.findMaxPosition()

            return lastRoundResult.carInfoList.filter { maxPosition == it.position }
        }
    }
}
