package carracing.util

fun <T : Any> T.requireAndPass(predicate: (T) -> Boolean, lazyMessage: () -> Any): T {
    require(predicate(this)) { lazyMessage }
    return this
}

fun String?.requireNotNullOrBlank(lazyMessage: () -> Any): String {
    require(!isNullOrBlank()) { lazyMessage }
    return this
}

fun String?.toIntOrThrow(lazyMessage: () -> Any): Int {
    return requireNotNullOrBlank(lazyMessage)
        .toIntOrNull()
        ?: throw IllegalArgumentException(lazyMessage().toString())
}
