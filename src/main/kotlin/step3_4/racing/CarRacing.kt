package step3_4.racing

class CarRacing(
    private val carList: List<Car>,
    private val numberOfRounds: Int
) {

    fun doRacing(showResult: (List<Car>) -> Unit) {
        repeat(numberOfRounds) {
            carList.forEach { car -> car.moveForward() }
            showResult(carList)
        }
    }
}
