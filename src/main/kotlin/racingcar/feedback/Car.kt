package racingcar.feedback

// 상수를 최상위 수준과 동반 객체 중 무엇으로 정의하느냐는 상수를 사용하는 클래스의 범위에 따라 다르다!
// 만약에 상수를 최상위 수준에서 선언하면 코틀린은 CarKt 이라는 클래스 파일을 생성하여 모아둔다.
// private const val ...

object Numbers {
    // 최상위 수준으로 선언했을 때의 단점은 개발자가 직접 상수 이름을 알아야 한다는 것이다.
    // 그래서 object 안에 상수를 선언해서 사용하기도 한다.
    const val MAXIMUM_NAME_LENGTH: Int = 5
}

class Car(val name: String, position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set // 커스텀 게터와 세터는 생성자에서 바로 사용할 수 없다!
    /*
    private var _position: Int = position
    val position: Int
        get() = _position
    */

    init {
        require(name.length <= Numbers.MAXIMUM_NAME_LENGTH) { "자동차 이름은 5글자를 넘길 수 없습니다." }
    }

    fun move() {
        position++
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0

        @JvmField
        val DEFAULT_CAR: Car = Car("")
        fun of(name: String): Car = Car(name)
    }
}
