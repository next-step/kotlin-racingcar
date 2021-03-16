package racingcar.userInput

data class UserNameInfo(private val userNamesInput: String) {
    val usernames: List<String> = parseUserNameList()

    private fun parseUserNameList(): List<String> {
        return userNamesInput
            .split(DELIMITER)
            .map { it.trim() }
    }

    companion object {
        const val DELIMITER = ","
    }
}
