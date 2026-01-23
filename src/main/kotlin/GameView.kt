package game.view

val DELIMITER = "-"

class GameView {

    fun showResult(list: List<Int>): String {
        val result = StringBuilder()

        for (item in list) {
            result.append(DELIMITER.repeat(item))
            result.append("\n")
        }

        println(result.toString())

        return result.toString()
    }
}
