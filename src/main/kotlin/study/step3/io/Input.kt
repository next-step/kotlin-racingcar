package study.step3.io

class Input {

    fun requestCarNames(callback: (List<String>) -> Unit) {
        val input: String = readlnOrNull() ?: return
        val carNames: List<String> = input.split(",")
        callback(carNames)
    }

    fun requestNumberOfRound(callback: (Int) -> Unit) {
        readlnOrNull()?.toIntOrNull()?.let(callback)
    }
}
