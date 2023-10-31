package step4.domain

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= 5) {
            "name should not be longer than 5"
        }
    }
}
