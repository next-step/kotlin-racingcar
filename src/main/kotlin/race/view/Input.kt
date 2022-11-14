package race.view

class Input {
    fun getCount(message: String): Int {
        println(message)
        return readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("It is not a number")
    }
}
