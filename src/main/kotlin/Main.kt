import game.car.Car
import game.manager.GameManager
import game.view.GameView

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carsCount = readLine().toString().toInt()

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readLine().toString().toInt()

    val cars = List(carsCount) { Car(position = 1) }
    val gameView = GameView()
    val gameManager = GameManager(cars = cars, gameView = gameView)
    println("실행 결과")
    gameManager.playRounds(tryCount)

}
