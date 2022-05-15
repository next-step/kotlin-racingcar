package racingcar

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    println("\n실행 결과")
    val driverList = List(carCount) { Driver(Car()) }

    repeat(tryCount) {
        driverList.forEach {
            val isMovable = (1..9).random() > 4
            it.drive(isMovable)

            println(it.getMoveResult())
        }
        println("")
    }
}