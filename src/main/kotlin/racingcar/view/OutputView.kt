package racingcar.view

import racingcar.view.output.Output

class OutputView(private val output: Output) {

    fun show(movingDistances: List<Int>) {
        val message = movingDistances.joinToString("") { "${this.statusBy(it)}\n" }
        output.show(message)
    }

    fun statusBy(movingDistance: Int): String {
        return (0 until movingDistance).joinToString("") { "-" }
    }
}
