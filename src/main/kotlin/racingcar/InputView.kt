package racingcar

object InputView {

    fun inputNumberOfCars(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return readln().toInt()
    }

    fun inputNumberOfMoves(): Int {
        println("시도할 회수는 몇 회 인가요?")
        return readln().toInt()
    }

    fun inputNameOfCars(): List<String> {
        println("자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
        return readln().split(",")
    }
}
