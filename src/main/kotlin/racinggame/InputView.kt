package racinggame

object InputView {

    fun input(str: String): Int {
        println(str)
        return readln().toInt()
    }
}