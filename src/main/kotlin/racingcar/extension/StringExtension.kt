package racingcar.extension

object StringExtension {
    fun String.isIntType(): Boolean {
        return try {
            this.toInt()
            true
        } catch (exception: IllegalArgumentException) {
            false
        }
    }
}
