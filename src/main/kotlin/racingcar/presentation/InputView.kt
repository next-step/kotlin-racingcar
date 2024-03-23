package racingcar.presentation

object InputView {

    fun inputCountOfCars(): Int {
        print("자동차 대수는 몇 대인가요? - ")
        return readln().toInt()
    }

    fun inputCountOfRacingRound(): Int {
        print("시도할 회수는 몇 회인가요? - ")
        return readln().toInt()
    }

    fun inputNamesOfCars(): List<String> {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분) - ")
        return readln().split(",")
    }
}
