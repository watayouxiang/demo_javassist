# javassist demo

- javassist 使用全解析
  - 使用 Javassist 创建一个 class 文件
  - javassist 调用生成的类对象
  - javassist 修改现有的类对象

- javassist 在安卓中的简单应用
  - 创建 gradle plugin 
  - 使用 Gradle Transform：是Android官方提供，用于编译期间(.class -> .dex期间)修改.class文件的一套API
  - 使用 javassist：修改.class文件

- apk打包过程：java源码 --> class --> dex文件 --> apk
  - apt、aspectj 作用在：java源码 --> class 期间
  - javassit 作用在：class --> dex文件 期间
