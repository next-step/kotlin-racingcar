package racing.model

class Names(val names: List<Name>) {
    init {
        require(names.isNotEmpty()) { INVALID_CAR_NAMES }
    }

    fun forEach(action: (Name) -> Unit) = names.forEach(action)

    companion object {
        const val INVALID_CAR_NAMES = "자동차 이름은 1개 이상이여야 합니다."
    }
}
