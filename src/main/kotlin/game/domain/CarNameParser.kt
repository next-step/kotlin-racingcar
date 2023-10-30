package game.domain

object CarNameParser {
    fun parse(input: String): List<String> {
        return input.split(",")
    }
}
