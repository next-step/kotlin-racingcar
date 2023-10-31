package step4.domain

data class RacingCars(val carList: List<RacingCar>) {
    val winner
        get() = run {
            val maxMove = carList.maxOf { it.moveCount }
            carList.filter { it.moveCount == maxMove }
        }
}
