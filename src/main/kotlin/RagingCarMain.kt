
fun main() {

    val inputData = InputView.doInput()
    val carNumber = inputData.first
    val actionCount = inputData.second

    val cars = mutableListOf<Car>()
    repeat(carNumber) {
        cars.add(Car())
    }

    ResultView.showResult(cars, actionCount)
}
