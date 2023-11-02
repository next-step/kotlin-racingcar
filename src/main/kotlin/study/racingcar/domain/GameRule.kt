package study.racingcar.domain

interface GameRule {

    // TODO-review : interface 로 규격을 만들고 싶었습니다.
    //  하지만, 만약 새로운 게임룰은 결과를 받을때, int 가 아닌 다른 타입을 받아야 한다면, interface 에 새로운 fun 이 추가되어야 합니다.
    //  이렇듯 새로운 기능이 추가될때마다 interface 를 수정하는건 best-practice 가 아닌것 같은데요.
    //  이를 해결하기 위한 방법이 있을까요? 조언 부탁드립니다.
    fun getResult(num: Int): Boolean
}
