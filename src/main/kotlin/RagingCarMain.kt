
fun main(args: Array<String>) {

    val inputView = InputView()
    inputView.doInput()

    val carList = ArrayList<Car>()
    for(i in 0 until inputView.carNumber) {
        carList.add(Car())
    }

    ResultView().showResult(carList, inputView.actionCount)


}