package expressioncalculator.inspector

inline fun mustNot(exception: Exception = IllegalArgumentException(), block: () -> Boolean) {
    if (block()) throw exception
}
