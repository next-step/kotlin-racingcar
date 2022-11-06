package racingcar

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    println("자동차 대수는 몇 대인가요?")
    val carNumber = inputView.input()

    val carList = mutableListOf<Car>()
    for (i in 1..carNumber) {
        carList.add(Car())
    }

    println("시도할 횟수는 몇 회인가요?")
    val count = inputView.input()
    resultView.printResult(carList, count)
}
