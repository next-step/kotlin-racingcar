package racing.ui

class ResultView {

    companion object {
        fun requireCarsCount() {
            println("자동차 대수는 몇 대인가요?")
        }

        fun requireNumberOfGames() {
            println("시도할 횟수는 몇 회인가요?")
        }

        fun printGameResult(result: String) {
            println("실행결과")
            println(result)
        }
    }
}
