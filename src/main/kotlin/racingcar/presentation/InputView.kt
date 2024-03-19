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
}
