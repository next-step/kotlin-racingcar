package racingcar

class RacingView {
    class InputView {

        companion object {
            private const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
            private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

            fun displayCarNames() = println(INPUT_CAR_NAMES)
            fun displayRoundCount() = println(INPUT_ROUND_COUNT)
        }
    }

    class OutputView {

        companion object {
            private const val RESULT_TITLE = "실행결과"
            private const val POSITION_VIEW = "-"

            fun display(cars: List<Cars>) {
                println(RESULT_TITLE)
                cars.forEach {
                    it.cars.forEach { car ->
                        print(car.name + " : ")
                        getDistanceView(car.position)
                        println()
                    }
                    println()
                }
            }

            private fun getDistanceView(distance: Int) {
                for (i in 0..distance) print(POSITION_VIEW)
            }
        }
    }
}
