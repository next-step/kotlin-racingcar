package racing

data class Name private constructor(val name: String) {
    companion object {
        fun of(name: String): Name {
            if (name.length >= 5) {
                throw IllegalArgumentException("이름은 5자 이상 일 수 없습니다.")
            }
            return Name(name)
        }
    }
}
