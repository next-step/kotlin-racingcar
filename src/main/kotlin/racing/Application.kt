package racing

fun main() {
    val inputView = InputView()
    val cars = inputView.getNames("자동차 이름을 입력하세요")
    val tryCount = inputView.get("시도할 횟수는 몇 회인가요?")
    
    Game(cars, tryCount).start()
}
