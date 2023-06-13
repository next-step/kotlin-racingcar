package carGame.view

import carGame.domain.CarName

object InputView {
    fun getCarNames(): List<CarName> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readln()
        return input
            .split(',')
            .map { CarName(it.trim()) }
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = readln().toInt()
        require(input > 0) { "시도 횟수는 0보다 커야합니다." }
        return input
    }
}
