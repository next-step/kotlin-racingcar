# kotlin-racingcar

## STEP1 (1단계 - 코틀린 기초)
### 실습 환경 구축
[자동차 경주 저장소](https://github.com/next-step/kotlin-racingcar)를 기반으로 미션을 진행한다. [온라인 코드 리뷰 요청 1단계 문서](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)를 참고해 실습 환경을 구축한다.
1. 미션 시작 버튼을 눌러 미션을 시작한다.
2. 저장소에 자신의 GitHub 아이디로 된 브랜치가 생성되었는지 확인한다.
3. 저장소를 [자신의 계정](https://github.com/wjdtlr0920/kotlin-racingcar)으로 Fork 한다.
4. 요구 사항에 대한 구현을 완료한 후, 작업이 다 되었으면 Push를 한다.
5. kotlin-racingcar에서 Pull Request를 작성한다.
6. 리뷰 받은 내용을 토대로 코드를 리팩터링하고 다시 Push를 한다.
7. 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.
   
   
+ 코드리뷰 요청 1단계 [[동영상]](https://www.youtube.com/watch?v=YkgBUt7zG5k) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)
+ 코드리뷰 요청 2단계 [[동영상]](https://www.youtube.com/watch?v=HnTdFJd0PtU) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step2.md)
+ 코드리뷰 요청 3단계 [[동영상]](https://www.youtube.com/watch?v=fzrT3eoecUw) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step3.md)

### 자바-코틀린 변환기
새로운 언어를 배워 써먹을 만큼 숙련도를 높이려면 많이 노력해야 한다. 코틀린을 처음 배웠는데 정확한 코틀린 문법이 기억나지 않는 경우 유용하게 써먹을 수 있다.

+ 작성하고픈 코드를 자바로 작성해 복사한 후 코틀린 파일에 그 코드를 붙여 넣는다.
+ Code > Convert Java File to Kotlin File(⌥⇧⌘K, Ctrl+Shift+Alt+K)을 선택한다.



## STEP2 (2단계 - 문자열 계산기)
### 기능 요구 사항
+ 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
+ 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
+ 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구 사항
+ 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 힌트
테스트할 수 있는 단위로 나누어 구현 목록을 만든다.

+ 덧셈, 뺄셈, 곱셈, 나눗셈
+ 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
+ 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
+ 사칙 연산을 모두 포함하는 기능 구현
+ 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다. 반복적인 패턴을 찾아 반복문으로 구현한다.

### 추가 기능 요구 사항
+ 클래스, 함수, 변수명은 이름만으로 의도가 전달되도록 작성
+ 불필요한 주석 제거 및 public한 클래스나 함수를 KDoc기반 주석으로 작성(수학적인 공식, 외부에 의한 요인, 특정상황의 성능차이등 협업시 필요한 정보 제외)
+ 자주 접근해 사용해야 하는 기능이 있는 경우에는 instance 생성보다 object class로 가는게 좋음
+ require(IllegalArgumentException), check(IllegalStateException)로 유효성 검증 가능
+ 사칙연산 뿐만 아니라 연산자 부호 추가 등 확장을 고려한 설계 필요
+ 하드코딩보단 상수 값을 따로 분리해서 사용하는게 가독성이 더 좋음
+ mutable보단 immutable로 컬렉션 사용하는게 좋음
+ depth는 최대한 적게 가져가려고 노력해야하며 함수 분리를 잘하면 좋음
+ 다양한 테스트 조건 추가
+ README 작성시 개발항목 산출과 정리가 좀 더 용이해지고 프로젝트의 대한 가독성도 높아지는 효과가 있음

## STEP3 (3단계 - 자동차 경주)
### 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

+ 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
+ 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
+ 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  + 무작위 값이 4이상일 경우 true를 반환한다
  + 무작위 값이 3이하일 경우 false를 반환한다.
  + 무작위 값이 0이하이거나 9이상일 경우 예외를 던진다.
+ 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

### 실행 결과
위 요구 사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

 자동차 대수는 몇 대인가요?<br/>
 3<br/>
 시도할 횟수는 몇 회인가요?<br/>
 5<br/>

 실행 결과<br/>
 ㅡ<br/>
 ㅡ<br/>
 ㅡ<br/>

 ㅡㅡ<br/>
 ㅡ<br/>
 ㅡㅡ<br/>

 ㅡㅡㅡ<br/>
 ㅡㅡ<br/>
 ㅡㅡㅡ<br/>

 ㅡㅡㅡㅡ<br/>
 ㅡㅡㅡ<br/>
 ㅡㅡㅡㅡ<br/>

 ㅡㅡㅡㅡ<br/>
 ㅡㅡㅡㅡ<br/>
 ㅡㅡㅡㅡㅡ<br/>

### 프로그래밍 요구 사항
+ 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
+ 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
+ UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.

### 힌트
+ 값을 입력 받는 API는 kotlin.io의 readLine을 이용한다.
+ val value: String? = readLine()
+ val value: String = readLine()!!
+ val number = readLine()!!.toInt()


## STEP4 (4단계 - 자동차 경주(우승자))
### 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
  - 자동차 이름이 빈 문자열 일 경우 예외(IllegalArgumentException)를 던진다.
  - 자동차 이름이 5자리를 초과하는 경우 예외(IllegalArgumentException)를 던진다.
  - 자동차 이름이 "pobi"로 주어 졌을 경우 "pobi"라는 자동차가 만들어 져야한다. 
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - 자동차 대수가 1대일 때 쉼표가 있으면 예외(IllegalArgumentException)를 던진다.
  - 자동차 쉼표가 연속으로 나올 경우 예외(IllegalArgumentException)를 던진다.
  - 자동차 이름이 "pobi,crong,honux"로 주어졌을 경우 자동차 객체는 3개가 만들어져야아며 각 이름은 "pobi", "crong", "honux"이여야 한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - 우승자가 한명도 없을 경우 예외(IllegalArgumentException)를 던진다.
  - 우승자가 한명일 경우 우승자의 숫자가 1이여야 한다.
  - 우승자가 3명일 경우 우승자의 숫자가 3이여야 한다.

### 기능 목록
- [x] 자동차는 이름을 가진다.
- [x] 자동차의 이름은 비어 있을 수 없다.
- [x] 자동차의 이름은 5자리를 초과할 수 없다.
- [x] 자동차의 이름은 쉼표(,)로 구분 된다.
- [x] 자동차 경주의 우승자가 1명일 수 있다.
- [x] 자동차 경주의 우승자가 여러명 일수 있다.

### 프로그래밍 요구 사항
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

### 실행 결과
위 요구 사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

 경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).<br/>
 pobi,crong,honux<br/>
 시도할 횟수는 몇 회인가요?<br/>
 5<br/>

 실행 결과<br/>
 pobi : -<br/>
 crong : -<br/>
 honux : -<br/>

 pobi : --<br/>
 crong : -<br/>
 honux : --<br/>

 pobi : ---<br/>
 crong : --<br/>
 honux : ---<br/>

 pobi : ----<br/>
 crong : ---<br/>
 honux : ----<br/>

 pobi : -----<br/>
 crong : ----<br/>
 honux : -----<br/>

 pobi, honux가 최종 우승했습니다.