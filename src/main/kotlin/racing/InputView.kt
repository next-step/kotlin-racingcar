package racing

object InputView {
    fun inputForRacing(): Pair<List<String>, Int> {
        val carNames = read("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val tryCount = read("시도할 횟수는 몇 회인가요?")
        return validate(carNames, tryCount)
    }

    private fun read(question: String): String {
        println(question)
        return readln()
    }

    private fun validate(carNamesString: String, tryCountString: String): Pair<List<String>, Int> {
        val carNames = carNamesString.split(",").onEach {
            require(it.length <= 5) {
                "자동차 이름은 5자를 초과할 수 없습니다."
            }
        }
        val tryCount = tryCountString.toInt()
        return carNames to tryCount
    }
}
