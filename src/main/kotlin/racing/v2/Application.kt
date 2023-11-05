package racing.v2

import racing.v2.console.InputView

fun main() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val carsStr: String? = readLine()

    println("시도할 횟수는 몇 회인가요?")
    val tryCountStr: String? = readLine()

    val carGame = InputView.createCarGame(carsStr, tryCountStr)
    carGame.start()
}
