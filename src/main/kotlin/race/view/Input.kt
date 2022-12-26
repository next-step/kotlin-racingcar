package race.view

object Input {

    fun getRaceCount(message: String): Int {
        println(message)
        return readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("It is not a number")
    }
    fun getCarNames(message: String): String {
        println(message)
        return readLine()
            ?: throw IllegalArgumentException("It is not a string")
    }
}
