package step4.domain

class RacingGameResultText {
    var middleResult: MutableList<String> = mutableListOf()
        private set
    var finalResult: String = ""
        private set

    fun saveMiddleResult(cars: RacingCars) {
        middleResult.add(
            StringBuilder().apply {
                for (car in cars.carList) {
                    appendLine(getCarMoveView(car))
                }
            }.toString()
        )
    }

    private fun getCarMoveView(car: RacingCar): String {
        return "${car.carName.name} : ${visualizeMoveCount(car.moveCount)}"
    }

    private fun visualizeMoveCount(moveCount: Int): String {
        return CAR_MOVE.repeat(moveCount)
    }

    fun saveFinalResultView(winnerList: List<RacingCar>) {
        finalResult += StringBuilder().apply {
            winnerList.forEachIndexed { index, car ->
                append(car.carName.name)
                append(getCommaIfNotLast(index != winnerList.size - 1))
            }
            append("가 최종 우승했습니다.")
        }.toString()
    }

    private fun getCommaIfNotLast(isNotLast: Boolean): String {
        return if (isNotLast) ", "
        else ""
    }

    companion object {
        const val CAR_MOVE = "-"
    }
}
