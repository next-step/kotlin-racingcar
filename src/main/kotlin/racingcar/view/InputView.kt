package racingcar.view

class InputView {

    companion object {
        fun inputCarNames(): List<String> {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

            return readLine()!!
                .split(",")
                .map { it.trim() }
                .onEach {
                    require(!(it.isEmpty() || it.length > 5)) { "자동차 이름은 빈값이거나 5자를 초과할 수 없습니다." }
                }
        }

        fun inputCountOfTry(): Int {
            println("시도할 횟수는 몇 회인가요?")

            try {
                return readLine()!!.toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("시도할 횟수를 올바르게 입력하세요.")
            }
        }
    }
}
