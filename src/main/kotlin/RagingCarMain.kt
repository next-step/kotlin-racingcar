
fun main(args: Array<String>) {

    val inputData = InputView.doInput()
    val carNumber = inputData.first
    val actionCount = inputData.second

    val carList = mutableListOf<Car>()
    for (i in 0 until carNumber) {
        carList.add(Car())
    }

    ResultView.showResult(carList, actionCount)
}
