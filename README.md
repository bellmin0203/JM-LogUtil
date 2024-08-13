# 사용방법


## settings.gradle.kts

**maven { url = uri("https://jitpack.io") }** 추가

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

## build.gradle (Module)

**implementation("com.github.bellmin0203:jmlog:1.0.1")**
```
dependencies {
   ...
   implementation("com.github.bellmin0203:jmlog:1.0.1")
}
```

---
**1. LogUtil 초기화**

   Android Application > onCreate() > ```LogUtil.init(context, logMode, tag)```

**2. LogLevel에 맞게 사용**
   
   LogUtil.d, LogUtil.i, LogUtil.e, LogUtil.w ...
