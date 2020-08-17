package racingcarwinner.view

import racingcarwinner.domain.Car

object InputView {

    fun inputcircuitnumber(): Int {
        println("Please Enter circuit number :")
        return readLine()!!.toInt()
    }

    fun inputcarname(): String {
        println("자동차 이름을 등록해주세요 : (이름은 (,) 쉼표를 기준으로 구분)")
        return readLine()!!.toString()
    }
}

object OutputView {
    fun printcircuit(cars: MutableList<Car>) {
        cars.forEach({ println("${it.name} :${"-".repeat(it.position)}") })
        println(" ")
    }

    fun printwinner(winners: List<Car>) {
        val winnerslist = winners.map { it.name }.toString().replace("[", "").replace("]", "")
        println("${winnerslist}가 최종 우승 했습니다.")
    }
}
