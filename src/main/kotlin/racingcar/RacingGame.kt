package racingcar

import kotlin.random.Random
import kotlin.random.nextInt

class RacingGame(
    carNames: List<String>,
    private val conditionGenerator: ConditionGenerator = RandomConditionGenerator(),
) {
    private val cars = Cars()

    init {
        for (carName in carNames) {
            cars.add(Car(carName))
        }
    }

    fun start(tryNum: Int) {
        repeat(tryNum) {
            cars.moveAllCars(conditionGenerator)
            ResultView().printResult(cars.getNameAndPositionOfCars())
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
    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()!!.split(",")
    }

    fun inputTryNum(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return readLine()!!.toInt()
    }
}

class ResultView {
    fun printResult(nameAndPositionOfCars: List<Pair<String, Int>>) {
        for (nameAndPosition in nameAndPositionOfCars) {
            println(nameAndPosition.first + " : " + "-".repeat(nameAndPosition.second))
        }
        println()
    }
}

fun main() {
    val carNames = InputView().inputCarNames()
    val carNum = carNames.size
    val tryNum = InputView().inputTryNum()

    val racingGame = RacingGame(carNames)
    println("\n실행 결과")
    racingGame.start(tryNum)
}
