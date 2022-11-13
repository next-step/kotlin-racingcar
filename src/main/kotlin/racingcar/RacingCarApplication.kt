package racingcar

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    var result = ""

    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carNames = inputView.inputCarNames()
    val carList = initCarList(carNames)

    println("시도할 횟수는 몇 회인가요?")
    val tryNumber = inputView.inputInt()

    println("\n실행 결과")

    val cars = Cars(carList)
    for (i in 1..tryNumber) {
        val moved = cars.move()
        result += moved + "\n"
    }

    val exec = Statistics.exec(cars)
    result += exec

    resultView.printResult(result)
}

private fun initCarList(carNames: List<String>): MutableList<Car> {
    val carList = mutableListOf<Car>()
    for (carName in carNames) {
        carList.add(Car(carName))
    }
    return carList
}
