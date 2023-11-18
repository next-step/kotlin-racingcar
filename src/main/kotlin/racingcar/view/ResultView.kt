package racingcar.view

class ResultView {
    companion object {
        fun displayRacingStartMessage() {
            println("실행 결과")
        }

        fun displayCarLocation(distance: Int) {
            println("-".repeat(distance))
        }
    }
}
