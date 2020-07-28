import java.util.Random
import java.util.Scanner

fun main() {
    val inputView = InputView()

    OutputView(carCount = inputView.carCount, playCount = inputView.playCount)
}

class InputView {
    private val scanner = Scanner(System.`in`)
    val carCount: Int
    val playCount: Int

    constructor() {
        print("자동차 대수는 몇대인가요? ")
        carCount = scanner.nextInt()
        print("시도할 횟수는 몇회인가요? ")
        playCount = scanner.nextInt()
    }
}

class OutputView {
    var carCount: Int = 0
    var playCount: Int = 0

    constructor(carCount: Int, playCount: Int) {
        val carList = arrayListOf<RacingCar>()
        for (carName in 1..carCount) {
            carList.add(RacingCar(carName = carName.toString()))
        }

        for (play in 1..playCount) {
            println("${play}회차 결과")
            carList.map {
                it.moving(Random().nextInt(10))
                it.printCarLocation()
            }
        }
    }
}

class RacingCar(val carName: String, var carDistance: Int = 0) {
    fun moving(count: Int) {
        if (count > 4) carDistance += count
    }

    fun printCarLocation() {
        var carLocation = ""
        for (x in 0..carDistance) {
            carLocation += "-"
        }
        println("${carName}번 회차 : $carLocation")
    }
}
