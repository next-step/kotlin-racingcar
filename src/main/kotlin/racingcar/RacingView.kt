package racingcar

class RacingView {
    class InputView {

        companion object {
            private const val INPUT_CAR_COUNT = "자동차 대수는 몇 대인가요?"
            private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

            fun displayCarCount() = println(INPUT_CAR_COUNT)
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
