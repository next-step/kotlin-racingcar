package carracing.util

fun String?.requireNotNullOrBlank(lazyMessage: () -> Any): String {
    require(!isNullOrBlank()) { lazyMessage }
    return this
}

fun String?.toIntOrThrow(lazyMessage: () -> Any): Int {
    return requireNotNullOrBlank(lazyMessage)
        .toIntOrNull()
        ?: throw IllegalArgumentException(lazyMessage().toString())
}
