package study.step3.io

class Input {

    fun requestNumberOfCar(callback: (Int) -> Unit) {
        readlnOrNull()?.toIntOrNull()?.let(callback)
    }

    fun requestNumberOfRound(callback: (Int) -> Unit) {
        readlnOrNull()?.toIntOrNull()?.let(callback)
    }
}
