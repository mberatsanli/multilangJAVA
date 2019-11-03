
# multilangJAVA


### Import the library
```java
import com.multilang.*;
```

## Using

####  > How to declare
```java
Multilang mlang = new Multilang();
```

#### > Set Languages Directory
```java
mlang.setLanguage(<String>);
```

#### > Getter and Setter function
| value | what is does | ouput |
|--|--|--|
| language | library selected language | string
| directory | library selected directory | string


#### > List the language in the defined direcory
```java
mlang.getLanguages(<Boolean>);
```

| paramters | what is does | output |
|-------------|--------------|--------|
| false | Getting for you language file(s) in directory | array |
| true | Print for you language file(s) in directory | string |


#### > How to create the language file (json)
For example, the folder with the language files: `../languages/` and we create a language folder in the directory. Create `LANGUAGE.json`  for example `ru.json` and  `az.json`
`"CALL_NAME": "TEXT or WORD"`
```json
// ru.json
{
	"merhaba": "Привет",
	"merhaba_kullanici": "Привет"
}

// az.json
{
	"merhaba": "Salamlar",
	"merhaba_kullanici": "Salam"
}
```

#### > How to get the text or word
```java
mlang.call(<string> CALLED NAME)
```

## Example Using
```java
# src/test.java
import  com.multilang.*;

public  class  test  {
	public  static  void  main(String[] args) {
		Multilang  mlang  =  new  Multilang();
		mlang.setLanguage("en"); // Set "en" language
		System.out.println(mlang.call("test")); // Output (string): This is a test
	}
}
```
