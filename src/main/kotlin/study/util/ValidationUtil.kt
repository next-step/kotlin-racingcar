package study.util

fun <T : Any> T.requireAndPass(predicate: (T) -> Boolean, lazyMessage: () -> Any): T {
    require(predicate(this)) { lazyMessage }
    return this
}

fun String?.requireNotNullOrBlank(lazyMessage: () -> Any): String {
    if (isNullOrBlank()) {
        throw IllegalArgumentException(lazyMessage().toString())
    }
    return this
}
