package racing.ui

object RacingInput {

    tailrec fun requestNumberOfCars(): Int {
        val numberOfCar = promptAndReadNumber("자동차 대수는 몇 대인가요?")

        return if (numberOfCar != null) numberOfCar else {
            println("숫자를 입력해 주세요.")
            requestNumberOfCars()
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
        println(prompt)
        return readlnOrNull()?.toIntOrNull()
    }
}
