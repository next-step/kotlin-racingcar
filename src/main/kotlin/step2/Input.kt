package step2

import java.lang.IllegalArgumentException

data class Input(val _text: String?) {
    init {
        checkNotNull(_text) { throw IllegalArgumentException() }
    }

    val text: String
        get() = _text!!
}
