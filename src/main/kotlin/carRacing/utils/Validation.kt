package carRacing.utils

object Validation {

    fun <T> validate(list: List<T>, condition: (param: T) -> Boolean, errorString: String): List<T> {
        if (!list.all { condition(it) }) {
            throw IllegalArgumentException(errorString)
        }
        return list
    }

    fun <T> validate(item: T, condition: (param: T) -> Boolean, errorString: String): T {
        if (condition(item)) {
            throw IllegalArgumentException(errorString)
        }
        return item
    }

}
