package racingcar

import kotlin.random.Random
import kotlin.random.nextInt

class RacingGame(
    carNum: Int,
    private val conditionGenerator: ConditionGenerator = RandomConditionGenerator(),
) {
    private val cars = Cars()

    init {
        repeat(carNum) {
            cars.add(Car())
        }
    }

    fun start(tryNum: Int) {
        repeat(tryNum) {
            cars.moveAllCars(conditionGenerator)
            ResultView().printResult(cars.getPositionOfCars())
        }
    }

    fun getWinners(): List<Car> {
        return cars.getWinners()
    }
}

interface ConditionGenerator {
    fun generate(): Int {
        return Random.nextInt(0..9)
    }
}

class RandomConditionGenerator : ConditionGenerator

class InputView {
    fun inputCarNum(): Int {
        println("경주할 자동차 대수는 몇 대 인가요?")
        return readLine()!!.toInt()
    }

    fun inputTryNum(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return readLine()!!.toInt()
    }
}

class ResultView {
    fun printResult(positionsOfCars: List<Int>) {
        for (position in positionsOfCars) {
            println("-".repeat(position))
        }
        println()
    }
}

fun main() {
    val carNum = InputView().inputCarNum()
    val tryNum = InputView().inputTryNum()

    val racingGame = RacingGame(carNum)
    println("\n실행 결과")
    racingGame.start(tryNum)
}
