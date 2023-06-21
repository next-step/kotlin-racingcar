package racingcar.view

class InputView {
    companion object {
        fun requestRound(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readln().toInt()
        }

        fun requestNumberOfCars(): Int {
            println("자동차 대수는 몇 대인가요?")
            return readln().toInt()
        }
    }
}
