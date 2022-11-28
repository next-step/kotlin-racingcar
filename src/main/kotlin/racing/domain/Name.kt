package racing.domain

@JvmInline
value class Name private constructor(val name: String) {
    companion object {
        fun of(name: String): Name {
            if (name.length > 5) {
                throw IllegalArgumentException("이름은 5자를 초과 할 수 없습니다.")
            }
            return Name(name)
        }
    }
}
