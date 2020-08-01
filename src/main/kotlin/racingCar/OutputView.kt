package racingCar

object OutputView {

    fun getCarRacingResult(racingCarResult: List<Car>) {
        racingCarResult.forEach { println(makeRacingMap(it.distance)) }
    }

    private fun makeRacingMap(distance: Int): String {
        return if (distance == 0) " " else "=".repeat(distance)
    }
}
