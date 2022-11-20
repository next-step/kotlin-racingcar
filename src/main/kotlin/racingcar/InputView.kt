package racingcar

private const val VALID_CAR_NAME_LENGTH = 5

object InputView {
    fun readCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = parseCarName(readln())

        val list = mutableListOf<Car>()
        for (name in names) {
            require(isValidLength(name)) { "글자수는 5자를 넘을 수 없어요" }

            list.add(
                Car(name = name)
            )
        }

        return list
    }

    fun readRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }

    private fun isValidLength(name: String): Boolean {
        return name.length <= VALID_CAR_NAME_LENGTH
    }

    private fun parseCarName(input: String): List<String> {
        return input.split(",")
    }
}
