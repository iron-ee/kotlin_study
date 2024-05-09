package main.kotlin.fp.method

/*
기존 java 코드 위에 자연스럽게 코틀린 코드를 추가할 수는 없을까? 해서 나온 함수

어떤 클래스 안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자.

확장함수 라는 개념은 확장프로퍼티 와도 연결된다.
-> 확장 프로퍼티의 원리는 확장함수 + Custom getter 와 동일함.
 */

// fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {   -> 확장하려는클래스 = 수신객체 타입
//   this 를 이용해 실제 클래스 안의 값에 접근        -> this = 수신객체
// }
fun String.lastChar(): Char {
    return this[this.length - 1]    // 함수 안에서는 this 를 통해 인스턴스에 접근 가능하다.
}



fun main() {
    val str = "ABC"
    println(str.lastChar())     // 원래 String 에 있는 멤버함수 마냥 사용할 수 있음 ㄹㅈㄷ
}


/*
QnA
1. 확장함수가 public 이고, 확장함수에서 수신객체 클래스의 private 함수를 가져오면 캡슐화가 깨지는거 아닌가 ?!
    => 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없음.

2. 멤버함수와 확장함수의 시그니처가 같다면 ?!
    => 멤버함수가 우선적으로 호출된다. 그렇다면, 확장함수를 만들었지만, 다른 기능의 똑같은 멤버함수가 생기면? 오류가 발생할 수 있음.

3. 확장함수가 오버라이드 된다면 ?!
    => 해당 변수의 현재 타입  즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정됨.

4. java 에서 kotlin 확장함수를 가져다 사용할 수 있나 ?!
    => 정적 메소드를 부르는 것처럼 사용 가능함.
 */