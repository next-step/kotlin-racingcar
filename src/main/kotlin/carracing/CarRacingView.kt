package carracing

class CarRacingView<T>(private val carCharacter: String, private val separator: String = "\n") {

    fun getViewString(carRacingManager: CarRacingManager<T>): String {
        return carRacingManager.getCarList().joinToString(
            transform = { car -> getCarLineView(car) },
            separator = separator
        )
    }

    private fun getCarLineView(car: Car): String {
        var result = carCharacter
        repeat(car.distance) { result += carCharacter }
        return result
    }
}
