package domain.step4.domain

@JvmInline
value class PrivateConstructor private constructor(val test: List<String>) {

    companion object {
        fun of(test: List<String>) = PrivateConstructor(test)
    }
}

