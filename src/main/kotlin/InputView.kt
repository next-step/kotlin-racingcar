import kotlin.properties.Delegates

class InputView {
    val carManager: CarManager
    var carCount by Delegates.notNull<Int>()
    var tryCount by Delegates.notNull<Int>()

    constructor(carManager: CarManager) {
        this.carManager = carManager
        println("자동차 대수는 몇 대인가요?")
        carCount = readLine()!!.toInt()
        carAdds()

        println("시도할 횟수는 몇 회인가요?")
        tryCount = readLine()!!.toInt()
        tryMoving(tryCount)
    }

    fun carAdds() {
        repeat(carCount) { carManager.add() }
    }

    fun tryMoving(tryCount: Int) {
        repeat(tryCount) { carManager.move(tryCount) }
    }
}
