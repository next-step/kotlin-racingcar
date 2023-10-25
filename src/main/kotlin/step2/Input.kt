package step2

import java.lang.IllegalArgumentException

data class Input(val text: String?) {
    init {
        checkNotNull(text) { throw IllegalArgumentException() }
    }
}
