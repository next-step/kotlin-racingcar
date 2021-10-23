package racingcar.domain

@JvmInline
value class Names private constructor(val values: List<Name> = listOf()) {

    companion object {
        private val EMPTY_NAMES = Names()

        fun of(names: List<String> = listOf()): Names {
            if(names.isEmpty()) return EMPTY_NAMES
            return Names(names.map { Name(it) })
        }
    }
}
