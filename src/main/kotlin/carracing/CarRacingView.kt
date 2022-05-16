package carracing

class CarRacingView(private val carCharacter: String, private val separator: String = "\n") {

    fun getViewString(carRacingManager: CarRacingManager<out Int>): String {
        return carRacingManager.getCarList().joinToString(
            transform = { car -> getCarLineView(car) }, separator = separator
        )
    }

    fun getWinnerViewString(carRacingManager: CarRacingManager<out Int>): String {
        val winnerNameString =
            carRacingManager.getWinnerCars()
                .joinToString(transform = { car: Car -> car.name }, separator = WINNER_VIEW_SEPARATOR)
        return "${winnerNameString}가 최종 우승했습니다."
    }

    private fun getCarLineView(car: Car): String {
        var result = "${car.name}: $carCharacter"
        repeat(car.distance) { result += carCharacter }
        return result
    }

    companion object {
        private const val WINNER_VIEW_SEPARATOR = "," + " "
    }
}
