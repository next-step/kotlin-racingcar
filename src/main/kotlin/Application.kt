import controller.RacingController

fun main() {
    try {
        val racingController = RacingController()

        val carNames = getValidCarNames()
        val attemptCount = getValidAttemptCount()
        val cars = racingController.createCars(carNames)

        println("\n실행 결과")
        val raceResults = racingController.startRace(cars, attemptCount)
        raceResults.forEach { println(it) }

        val winners = racingController.getWinners(cars)
        println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    } catch (e: IllegalStateException) {
        println("[ERROR] ${e.message}")
    }
}

fun getValidCarNames(): List<String> {
    while (true) {
        try {
            println("자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)")
            val carNames = readLine()
            return inputCarNames(carNames)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        } catch (e: IllegalStateException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun inputCarNames(input: String?): List<String> {
    if (input == null) {
        throw IllegalStateException("입력 값 null")
    } else if (input.isEmpty()) {
        throw IllegalArgumentException("입력 값 empty")
    }
    val carNames = input.split(",").map { it.trim() }.filter { it.isNotEmpty() }
    if (carNames.isEmpty()) {
        throw IllegalArgumentException("유효하지 않은 자동차 이름 입력")
    }
    val invalidNames = carNames.filter { it.length > 5 }
    if (invalidNames.isNotEmpty()) {
        throw IllegalArgumentException("자동차 이름 5자 초과")
    }
    return carNames
}

fun getValidAttemptCount(): Int {
    while (true) {
        try {
            println("시도할 회수는 몇회인가요?")
            val attemptCount = readLine()
            return  inputAttemptCount(attemptCount)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        } catch (e: IllegalStateException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun inputAttemptCount(input: String?): Int {
    if (input == null) {
        throw IllegalStateException("입력 값 null")
    } else if (input.isEmpty()) {
        throw IllegalArgumentException("입력 값 empty")
    }

    return try {
        val count = input.toInt()
        if (count <= 0) {
            throw IllegalArgumentException("시도 횟수는 양수만 가능")
        }
        count
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("시도 횟수는 숫자만 가능")
    }
}
