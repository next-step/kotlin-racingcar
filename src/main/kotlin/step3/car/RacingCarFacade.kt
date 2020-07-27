package step3.car

import step3.car.printer.CarPrinter
import step3.car.printer.CarPrinterImpl
import step3.car.rule.CarMovementRule
import step3.car.rule.CarMovementRuleImpl
import step3.turn.Turn
import step3.turn.TurnImpl
import step3.turn.TurnManager
import step3.turn.TurnManagerImpl

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val totalCar = readLine()!!.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val totalTurn = readLine()!!.toInt()

    val cars: List<Car> = (0 until totalCar).map { CarImpl() }
    val rule: CarMovementRule = CarMovementRuleImpl()
    val printer: CarPrinter = CarPrinterImpl()
    val turn: Turn = TurnImpl {
        cars.forEach {
            rule.moveCarByRule(it)
            printer.print(it)
        }
    }
    val turnManager: TurnManager = TurnManagerImpl(totalTurn, turn)
    RacingCarGame(turnManager).startRacing()
}

class RacingCarGame(private val turnManager: TurnManager) {
    fun startRacing() {
        while (!turnManager.isFinishOrProceed()) {
            println()
        }
    }
}
