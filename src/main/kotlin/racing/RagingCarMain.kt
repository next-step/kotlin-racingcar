package racing
fun main() {
    val inputData = InputView.doInput()
    val carNames = inputData.first
    val actionCount = inputData.second
    val cars = carNames.map {
        Car(it)
    }
    ResultView.showResult(cars, actionCount)
}
