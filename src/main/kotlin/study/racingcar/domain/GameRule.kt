package study.racingcar.domain

interface GameRule {

    // TODO-review : RacingCar 는 GameRule 을 구현한 객체를 주입받아 사용합니다.
    //  setGameRule 은 4이상의 숫자가 나올경우 이기는 gameRule 을 위해 선언되었습니다. (FourOrMoreGameRule)
    //  만약 다른 gameRule 이 적용될 경우, setGameRule 은 불필요한 선언이 될 수도 있는데요.
    //  이렇게 GameRule 중에 특정 케이스에만 속하는 경우, 인터페이스를 주입받아 동작하는 로직에서 에러가 나는데요.
    //  설계를 어떻게 해야할지 고민이 됩니다.
    fun setGameRule(num: Int)
    fun getResult(): Boolean
}
