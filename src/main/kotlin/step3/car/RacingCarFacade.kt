package step3.car

import step3.car.printer.CarPrinter
import step3.car.printer.CarPrinterImpl
import step3.car.rule.CarMovementRule
import step3.car.rule.CarMovementRuleImpl
import step3.turn.Turn
import step3.turn.TurnImpl
import step3.turn.TurnManager
import step3.turn.TurnManagerImpl

fun main(args: Array<String>) {
    println("자동차 대수는 몇 대인가요?")
    val number = readLine()!!.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val turns = readLine()!!.toInt()
    RacingCarFacade(number, turns).startRacing()
}

class RacingCarFacade(carNumber: Int, totalTurn: Int) {

    val cars: List<Car> = (0 until carNumber).map { CarImpl(it) }
    val rule: CarMovementRule = CarMovementRuleImpl()
    val printer: CarPrinter = CarPrinterImpl()
    val turn: Turn = TurnImpl {
        cars.forEach {
            rule.moveCarByRule(it)
            printer.print(it)
        }
    }
    val turnManager: TurnManager = TurnManagerImpl(totalTurn, turn)

    fun startRacing() {
        while (!turnManager.isFinishOrProceed()) {
            println()
        }
    }
}
