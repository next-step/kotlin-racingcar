package carGame.test

object TestUtil {
    fun generateRandomString(size: Int): String {
        val alphabet: List<Char> = ('a'..'z') + ('A'..'Z')
        return alphabet
            .shuffled()
            .take(size)
            .joinToString("")
    }
}
