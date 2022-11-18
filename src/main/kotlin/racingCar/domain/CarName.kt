package racingCar.domain

@JvmInline
value class CarName(val carName: String) {

    init {
        require(carName.isNotEmpty() && carName.length <= MAX_NAME_LENGTH)
        { "사용자 이름은 최소 한글자 이상 5글자 미만이여야만 합니다. 현재 :${carName.length} 글자" }
    }

    companion object {

        const val MAX_NAME_LENGTH = 5;

    }
}
