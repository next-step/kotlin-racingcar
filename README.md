# kotlin-racingcar
기능요구사항

[V] 각 자동차에 이름을 부여할 수 있다.
[V] 자동차 이름은 5자를 초과할 수 없다.
[ ] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
[ ] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
[ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

프로그래밍 요구 사항

모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.