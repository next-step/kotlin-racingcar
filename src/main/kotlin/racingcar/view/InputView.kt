package view

class InputView {
    fun inputCountCar(): String? {
        val countCar = "자동차 대수는 몇 대인가요?"
        println(countCar)
        return readln()
    }

    fun inputNamedCar(): String? {
        val namedCar = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        println(namedCar)
        return readln()
    }

    fun inputCountTrial(): String? {
        val countTrial = "시도할 횟수는 몇 회인가요?"
        println(countTrial)
        return readln()
    }
}
