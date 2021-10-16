package util

fun String?.toIntOrThrow(): Int = requireNotNull(this!!.toIntOrNull()) {
    "can't convert from \"$this\" to Int"
}
