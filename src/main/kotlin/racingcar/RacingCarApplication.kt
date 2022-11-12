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

    println("실행 결과\n")

    for (i in 1..count) {
        carList.forEach {
            it.move((randomNumberRange).random())
            print(it.name + " : ")
            print(makeResult(it.status))
        }
        println()
    }
}

fun makeResult(number: Int): String {
    val str: StringBuilder = StringBuilder()
    for (i in 1..number) {
        str.append("-")
    }
    str.append("\n")
    return str.toString()
}
