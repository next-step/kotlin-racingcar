package racingcar

class RacingCarView {
    companion object {
        fun printCarsInputView() {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
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

        fun printWinnerCars(racingCars: List<RacingCar>) {
            val winningCars = racingCars.joinToString(", ") { it.name }
            println(winningCars + "가 최종 우승했습니다.")
        }
    }
}

fun RacingCar.printPosition() {
    print("$name : ")
    for (i in 0 until position) {
        print("-")
    }
    println()
}
