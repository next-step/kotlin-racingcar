package racingcar

fun main() {
    val randomNumberRange = 0..9
    val inputView = InputView()

    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carNames = inputView.inputCarNames()

    val carList = mutableListOf<Car>()
    for (carName in carNames) {
        carList.add(Car(carName))
    }

    println("시도할 횟수는 몇 회인가요?")
    val count = inputView.inputInt()

    println("\n실행 결과")

    for (i in 1..count) {
        carList.forEach {
            it.move((randomNumberRange).random())
            val result = it.makeResult()
            print(result)
        }
        println()
    }

    val exec = Statistics.exec(carList)
    println(exec)
}