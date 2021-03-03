package racingcar

class Winners(private val names: List<String>) {

    fun joinToWinners(delimiter: String): String {
        return names.joinToString("$delimiter ")
    }
}
