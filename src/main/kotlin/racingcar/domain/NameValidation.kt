package racingcar.domain

fun interface NameValidation {
    fun validate(names: List<String>): Boolean

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}
