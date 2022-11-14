package calculator

class Validator {
    fun validate(s: String?): Boolean {
        isNullOrBlank(s)
        return true
    }

    private fun isNullOrBlank(s: String?) {
        if (s.isNullOrBlank()) throw IllegalArgumentException()
    }
    }
}
