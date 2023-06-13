package step3

class RacingCarView {
    companion object {
        fun printCarsInputView() {
            println("자동차 대수는 몇대인가요?")
        }

        fun printAttemptInputView() {
            println("시도할 횟수는 몇회인가요?")
        }

        fun printResultView() {
            println("실행 결과")
        }

        fun printCarsPosition(cars: List<RacingCar>) {
            cars.forEach {
                it.printPosition()
            }
            println()
        }
    }
}
