package carRacing.view

import carRacing.model.Car
import carRacing.model.Record

object ResultView {

    fun printTitle() {
        println("실행 결과")
    }

    fun printResultRecord(carNameList: List<String>, recordList: List<Record>) {
        recordList.forEach { record ->
            carNameList.zip(record.positions).forEach {
                var char = "_".repeat(it.second)
                println("${it.first}: $char")
            }
            println()
        }
    }

    fun printWinner(winnerList: List<Car>) {
        println("${winnerList.joinToString { it.name }}가 최종 우승했습니다.")
    }
}
