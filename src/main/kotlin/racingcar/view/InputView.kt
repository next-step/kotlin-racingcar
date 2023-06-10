package racingcar.view

class InputView {
    fun namesOfCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",")
    }

    fun numberOfAttempts(): Int {
        println("시도할 회수는 몇 회 인가요?")
        return readln().toInt()
    }
}
