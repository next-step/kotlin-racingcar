package step3.view

object InputView {
    fun requestNameOfCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",").toList()
    }

    fun requestCountOfTrial(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
