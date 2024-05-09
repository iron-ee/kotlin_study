package main.kotlin.oop.`object`

/*
-> java 에서 singleton 만들 때 이런식으로 만들거나
동시성 처리를 조금 더 해주거나, enum class 를 활용하는 등의 방법이 있었음

public class JavaSingleton {

  private static final JavaSingleton INSTANCE = new JavaSingleton();

  private JavaSingleton() { }

  public static JavaSingleton getInstance() {
    return INSTANCE;
  }
}
 */

// kotlin 에서는 매우 간단.. object 키워드 끝..
object Singleton {
    var num: Int = 0
}


/*
kotlin 에서 싱글톤 클래스를 만들 땐 object 키워드 사용
 */