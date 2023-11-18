package racing

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val cars = inputView.getNames("자동차 이름을 입력하세요")
    val tryCount = inputView.get("시도할 횟수는 몇 회인가요?")
    
    val game = Game(cars)

    repeat(tryCount) {
        val cars = game.run()
        resultView.view(cars)
    }
    
    resultView.viewWinner(game.end())
}
