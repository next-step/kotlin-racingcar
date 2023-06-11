
fun main() {

    val inputData = InputView.doInput()
    val carNumber = inputData.first
    val actionCount = inputData.second

    val cars = mutableListOf<Car>()
    carNumber.forEach {
        cars.add(Car(it))
    }

    ResultView.showResult(cars, actionCount)
}
