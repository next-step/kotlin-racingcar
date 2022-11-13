package racingCar.domain

@JvmInline
value class Username( val username:String) {

    init {
        require(username.isNotEmpty()) {"사용자 이름은 최소 한글자 이상이여야만 합니다."}
    }
}
