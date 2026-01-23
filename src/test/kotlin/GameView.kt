package game.view

class GameView {

    fun showResult(list: List<Int>): String {
        val result = StringBuilder()

        for (item in list) {
            result.append("-".repeat(item))
            result.append("\n")
        }

        return result.toString()
    }
}
