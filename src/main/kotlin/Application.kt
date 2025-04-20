fun main() {
    try {
        val carNames = getValidCarNames()
        println("최종 입력된 자동차 이름:")
        carNames.forEach { println(it) }
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
