package racingcar.domain

fun interface NameValidation {
    fun test(names: List<String>): Boolean

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}
