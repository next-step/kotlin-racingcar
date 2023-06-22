package racingcar

import kotlin.random.Random
import kotlin.random.nextInt

class RacingGame(
    carNames: List<String>,
    private val conditionGenerator: ConditionGenerator = RandomConditionGenerator(),
) {
    private val cars: Cars = Cars(carNames)

    val winners: List<Car>
        get() = cars.winners

    fun start(tryNum: Int) {
        repeat(tryNum) {
            cars.moveAllCars(conditionGenerator)
            ResultView().printResult(cars.namesAndPositions)
        }
        ResultView().printWinners(winners)
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
        return readln().split(",")
    }

    fun inputTryNum(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return readln().toInt()
    }
}

class ResultView {
    fun printResult(namesAndPositionsOfCars: List<Pair<String, Int>>) {
        for ((name, position) in namesAndPositionsOfCars) {
            println("$name : ${"-".repeat(position)}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        winners.map { it.carName.name }.joinToString(", ").let {
            println(it + "가 최종 우승했습니다.")
        }
    }
}

fun main() {
    val carNames = InputView().inputCarNames()
    val tryNum = InputView().inputTryNum()

    val racingGame = RacingGame(carNames)
    println("\n실행 결과")
    racingGame.start(tryNum)
}
