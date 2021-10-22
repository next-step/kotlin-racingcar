package racingcar.domain

@JvmInline
value class Names private constructor(val list: List<Name>) {

    fun display(): String {
        return list.joinToString { it.value }
    }

    companion object {
        fun of(): Names {
            return of(listOf())
        }

        fun of(names: List<String>): Names {
            return Names(names.map { Name(it) })
        }
    }
}
