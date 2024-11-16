package racingcar

fun main() {
    val carCount = InputView.getCarCount()
    val gameCount = InputView.getGameCount()
    val carGame = CarGame(carCount, gameCount)

    println("실행 결과")
    while (carGame.isRunning()) {
        carGame.playGame()
        println(carGame.getResult())
    }
}
