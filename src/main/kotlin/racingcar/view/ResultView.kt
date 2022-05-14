package racingcar.view

import racingcar.view.result.Output

class ResultView(private val output: Output) {

    fun show(movingDistances: List<Int>) {
        val message = movingDistances.joinToString("") { "${this.statusBy(it)}\n" }
        output.show(message)
    }

    fun statusBy(movingDistance: Int): String {
        return (0 until movingDistance).joinToString("") { "-" }
    }
}
