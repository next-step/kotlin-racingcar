package racing
fun main() {
    val inputData = InputView.doInput()
    val carNames = inputData.first
    val actionCount = inputData.second
    val cars = mutableListOf<Car>()
    carNames.forEach {
        cars.add(Car(it))
    }
    ResultView.showResult(cars, actionCount)
}
