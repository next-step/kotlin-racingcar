package racing.ui

object RacingInput {

    tailrec fun requestCarNames(): String {
        val carNames = promptAndRead("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        return if (carNames != null) carNames else {
            println("유효한 자동차 이름을 입력하세요. Input: $carNames")
            requestCarNames()
        }
    }

    tailrec fun requestNumberOfRound(): Int {
        val numberOfCar = promptAndReadNumber("시도할 횟수는 몇 회인가요?")

        return if (numberOfCar != null) numberOfCar else {
            println("숫자를 입력해 주세요.")
            requestNumberOfRound()
        }
    }

    private fun promptAndReadNumber(prompt: String): Int? {
        return promptAndRead(prompt)?.toIntOrNull()
    }

    private fun promptAndRead(prompt: String): String? {
        println(prompt)
        return readlnOrNull()
    }
}
