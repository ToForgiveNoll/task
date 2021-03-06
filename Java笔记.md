[toc]

# JAVA基础

## jdk11的目录结构

- bin目录 `该目录下主要存放JDK的各种工具命令`
- conf目录 `该目录下主要存放JDK的相关配置文件`
- include目录 `该目录下主要存放了一些平台的头文件`
- jmods目录 `该目录下主要存放了JDK的各种模块`
- legal目录 `该目录下主要存放了JDK各模块的授权文档`
- lib目录 `该目录下主要存放了JDK工具的一些补充jar包和源码`

## java编译及运行

**编译及运行前 先打开文件所在路径**

编译：

`javac [java文件名].java`

运行：

`java [java文件名]`

**java11新特性**

简化编译（**慎用**）：

`java [java文件名].java `

## 注释

单行注释

```java
// 我是注释
```

多行注释 

```java
/*
	我是注释
*/
```

**文档注释**

```java
/**
	我是注释
*/
```

## 变量

**基本概念**

当需要在程序中记录单个数据内容是，则声明一个变量即可，变量的本质就是在内存中申请一个存储单元，由于该存储单元中的数据内容可以发生改变，因此得名为**变量**

由于存放的数据内容大小不一样，导致所需存储单元的大小不一样，使用数据类型加以描述，为了便于下次访问还需要给该变量指定一个名字，用于记录该变量对应的存储单元

**变量的声明方式**

```java
1. 声明不赋值
[数据类型] [变量名];
int num;

2. 声明并赋值
[数据类型] [变量名] = [初始值];
int num = 233;

3. 同时声明多个同类型变量
[数据类型] [变量名],[变量名],[变量名],[变量名];
int num1,num2,num3,num4;

4. 声明多个变量并赋值
[数据类型] [变量名] = [初始值],[变量名],[变量名],[变量名];
int num1 = 5,num2,num3,num4;
```

**注意事项**

1. 使用前需要声明
2. 使用前需要初始化
3. 变量不能重复声明

## 标识符命名规则

1. 由数字、字母下划线以及$等组成，其中数字不能开头
2. 不能使用关键字
3. 区分大小写，长度没有限制
4. 支持中文，但不建议使用
5. 尽量有意义
6. 标识符可以给类/变量/属性/方法/包 起名字

## 数据类型

数据类型分为两大类：

1. 基本数据类型

   `byte、short、int、long、float、double、boolean、char`

2. 引用数据类型

   `数组、类、接口、枚举、标注`

### 单个字节表示的整数范围

在计算机中单个字节表示八位二进制数，其中最高位(最左边)代表符号位，使用0代表非负数，使用1代表负数，具体表示的整数范围如下：

```java
非负数范围： 0 ~ 127
0000 0000 ~ 0111 1111

0111 1111 => 0 + 64 + 32 + 16 + 8 + 4 + 2 + 1
          => 127

负数范围：-128 ~ -1
1000 0000 ~ 1111 1111

1000 0000 => 先减1：0111 1111
    	  => 按位取反：1000 0000
    	  => 转为十进制: 128
          => 添加负号：-128
              
1111 1111 => 先减1：1111 1110
          => 按位取反：0000 0001
    	  => 转为十进制: 1
          => 添加负号：-1
              
单个字节的范围：-128 ~ 127
```

### 整数类型

- 描述整数数据类型的变量有：byte、short、int、long
- byte类型在内存空间占1个字节 `-2^7 ~ 2^7-1`
- short类型在内存空间占2个字节 `-2^15 ~ 2^15-1`
- int类型在内存空间占4个字节 `-2^31 ~ 2^31-1`
- long类型在内存空间占8个字节 `-2^63 ~ 2^63-1`



**整数默认为int类型**

**如果希望表达更大的直接量，则在变量后面加上l或者L，推荐L，用于表示long**

**如果希望表达比long更大的整数类型，则使用java.math.BigInteger类型**

#### 常见错误

```java
1. int为转化为long
long a = 33333333333333333； // 错误：整数太大
修正：
long a = 33333333333333333L；

2. int未转换byte
int a = 25;
byte b = a;// 错误：不兼容的类型：从int转换到byte可能会有损失
System.out.println(b); 
修正：
int a = 25;
byte b = (byte)a;
System.out.println(b);
```

### 浮点类型

- 用于描述小数数据的类型：float和double，推荐double类型

- float类型在内存空间中占4个字节，叫做单精度浮点数，可以表示7位有效数字 `3.403E38 ~ 3.403E38`
- double类型在内存空间中占8个字节，叫做双精度浮点数，可以表示15位有效数字 `-1.798E308 ~ 1.798E308`



**浮点默认为double类型**

**如果希望表达更小的直接量，则在变量后面加上f或者F，推荐F，用于表示float**

**如果希望精确运算这借助java.math.BigDecimal类型**

#### 常见错误

```java
System.out.println(0.2+0.3); // 0.300000000000000004 运算时可能会有误差
```

### 布尔类型

- 用于描述真假信息的类型：boolen，数值为 ture和false
- 布尔类型在内存空间所占大小没有明确规定，可以认为是1个字节

### 字符类型

- 用于描述单个字符的数据类型：char
- char类型在内存空间中占2个字节并且没有符号位，表示的范围是：0 ~ 65535
- 由于现实生活中很少有数据能够被单个字节描述，因此以后的开发中更多的使用由多个字符串起来组成的字符串，使用String类型描述
- 计算机底层只识别0和1组成的二进制序列，对于字符'a'这样的图案来说不满足改规则，因此该数据无法直接在计算机中存储，但现实生活中存在这样的图案数据需要计算机存储，为了使得该数据能够存储起来就可以给该数据指定一个编号，然后将编号存储起来即可，该编号就叫做ASCII
- 常用的ASCII：`'0' - 48 'A' - 65 'a'-97 空格 - 32 换行符 - 10`
- java字符集采用Unicode字符集编码。Unicode是世界通用的定长字符集，所有字符都是16位

#### 转义字符

- `\` 转化原有的含义为字符串本身
- `\n` 换行
- `\t` 制表符
- `\r` 回车

### 基本数据类型之间的转化

- 基本数据类型之间的转化方式：自动类型转化和强制类型转化

- 其中自动类型的转换主要是指从小类型到大类型之间的转换

- 其中强制类型的转换主要是指从大类型到小类型之间的转换

  ```java
  [目标类型] [变量名] = ([目标类型])[变量名]
  int a = 10000;
  byte b = (int)a;
  ```


## 常用进制

二进制中的最高位用于代表符号位，1为负，0为正

八进制和十六进制都是二进制的简写

**进制前缀**

二进制：0b或者0B

八进制：0

十六进制：0x或者0X

### 补码（大坑 有待扩展）

计算机中的有符号数有三种表示方法，即原码、反码和补码

三种表示方法均有符号位和数值位两部分，符号位都是用0表示**正**，用1表示**负**，而数值位，三种表示方法各不相同

在计算机系统中，数值一律用补码来表示和存储。原因在于，使用补码，可以将符号位和数值域统一处理；同时，加法和减法也可以统一处理

### 进制之间的转换

**正十进制转换为二进制的方式**

1. 除二取余法，使用十进制整数不断地除以2取出余数，直到商为0时将余数逆序排序

2. 拆分法，将十进制整数拆分为若干个二进制权重的和，有该权重下面写1，否则写0

   ```java
   ... 128 64 32 16 8 4 2 1
   二进制 0 0  1  0  1 1 0 1
   十进制 45 => 32 + 8 + 4 + 1
   ```

**正二进制转换为十进制的方法**

加权法，使用二进制中的每个数字乘以当前位的权重再累加起来（参考拆分法）

**负十进制转换为二进制的方法**

先将十进制的绝对值转化为二进制，然后按位取反再加1

**负二进制转换为十进制的方法**

先减1再按位取反，合并为十进制整数后添加负号

## 运算符

- `+`表示加法运算符
- `-` 表示减法运算符
- `*`表示乘法运算符
- `/`表示除法运算符
- `%`表示取模/取余运算符

### 常见错误

```java
System.out.println(5 / 2);// 2 整数默认为int 不保留小数部分
System.out.println((double)(5 / 2));// 2.0
System.out.println((double)(5 / 0));// 编译ok，运行发生java.ArithmeticException(算术异常): / by zero
System.out.println((double)(5 / 0.0));// Infinity
System.out.println((double)(0 / 0.0));// NaN
```

### 字符串连接运算符

`+`可以实现字符串的连接，同时可以实现字符串与其他数据的连接

### 关系运算符

- `>`表示是否大于运算符
- `>=`表示是否大于等于运算符
- `<`表示是否小于运算符
- `<=`表示是否小于等于运算符
- `==`表示是否等于运算符
- `!=`表示是否不等于运算符
- 所有关系运算符的结果一定是boolen

### 自增减运算符

- `++`表示自增预算符，用于使得当前变量自身加1
- `--`表示自减运算符，用于使得当前变量自身减1
- 运算符再前则先加，再后则后加

#### 常见错误

```java
int ia = 14;
System.out.println(ia++ + ++ia); // 30  14 + 16
```

### 逻辑运算符

- `&&` 表示逻辑与运算符，相当于并且，同真为真，一假为假
- `||` 表示逻辑或运算符，相当于或者，一真为真，同假为假
- `！` 表示逻辑非运算符，相当于取反，真为假，假为真
- 逻辑运算的操作数均为boolean表达式

#### 逻辑运算符的短路特性

- 逻辑与运算符，若第一个表达式为假则结果为假，跳过第二个表达式
- 逻辑或运算符，若第一个表达式为真则结果为真，跳过第二个表达式

### 条件/三目运算符

- `[条件表达式] ? [表达式1] : [表达式2]`
- 判断条件表达式是否成立，若成立则执行表达式1，否则执行表达式2

### 赋值运算符

- `=`表示赋值运算符，用于将=右边的数据赋值给左边的变量，覆盖变量原来的数据
- 赋值表达式本身也有值，其本身的值为所赋的值
- `+= -= *= /= ...`

**常见错误**

```java
byte b1 = b1 + 2; // 错误：不兼容的类型 从int转化到byte可能有损失
byte b1 = b1 + (byte)2; // 错误：不兼容的类型 从int转化到byte可能有损失
byte b1 = (byte)(b1 + 2);
byte b1 += 2;
```

### 移位运算符

- `<<`左移运算符，用于将数据的二进制位向左移动，右边使用0补充
- `>>`右移运算符，用于将数据的二进制位向右移动，左边使用符号位补充
- `>>>`逻辑右移运算符，用于将数据的二进制位向右移动，左边使用0补充

### 位运算符

- `&`表示按位与运算符，按照二进制位进行与运算，同1为1，一0为0
- `|`表示按位或运算符，按照二进制位进行或运算，一1为1，同0为0
- `~`表示取反运算符，按照二进制位进行取反，1为0，0为1
- `^`表示按位异或运算符，按照二进制位进行异或运算，同为0，不同为1

## 流程控制语句

### if分支结构

```java
if(条件表达式){
    语句块;
}

如果条件表达式成立则执行1，否则执行2
if(条件表达式){
    语句块1;
}else{
    语句块2;
}

if(条件表达式){
    语句块1;
}else if(条件表达式){
    	语句块2;
	}else{
    	语句块3;
    }
```

### switch case分支结构

```java
switch(变量/表达式){
    case 字面值1:
    	语句块1；
        break;
    case 字面值2:
    	语句块2；
        break;
    ...
    default:
    	语句块n;
    break;
}
```

### for循环

```java
for(初始化表达式;条件表达式;修改初始值表达式){
    循环体;
}
```

#### continue关键字

用于提前结束本次循环开始下一次循环

#### break关键字

结束当前循环

### while循环

```java
while(条件表达式){
    循环体;
}

至少执行一次
do{
    循环体;
}while(条件表达式)
```

#### 常见错误

```java
while(条件表达式);{ // 增加分号后下面代码不再执行
    循环体;
}
```

## 数组

### 一维数组

- 当需要记录多个类型相同的数据内容时，则声明一个一维数组即可，一维数组本质上就是在内存空间申请一段连续的存储单元

- 数组是相同数据类型的多个元素的容器，元素按线性顺序排列，在java语言中体现为一种引用数据类型

  ```java
  [数据类型][] [数组名称] = new [数据类型][[数组的长度]];
  ```

- 调用数组的length属性可以获取数组的长度

- 可以通过下标的方式访问数组中的每个元素，数组下标从**0**开始

#### 数组优缺点

- 可以通过下标的方式访问指定位置的元素
- 数组要求所有元素的类型相同
- 数组要求内存空间连续，并且长度一旦确定就不能修改
- 增加和删除元素时，可能移动大量元素，效率低

#### 常见错误

```java
int[] a = {1,2,3,4};
int[] b = a; // b指向的是a所在的堆空间 共用一个堆
```

#### 数组工具类

- java.util.Arrays类可以实现对数组中元素的遍历、查找、排序等操作
- 具体使用查找源码

### 二/多维数组

- 二维数组本质上就是由多个一维数组摞在一起组成的数组，二维数组中的每个元素都是一堆数组，而一维数组中的每个元素才是数据内容

- ```java
  [数据类型][][] [数组名称] = new [数据类型][行数][列数];
  ```

#### 常见错误

```java
int[][] arr = new int[3][]; // 多维数组声明时可以暂时不声明列数 并且每一行列数可以不等
```

## 类和对象

- 万物皆对象
- 面向对象指以属性和行为的观点去分析现实生活中的事物
- 面向对象编程指先以面向对象的思想去进行分析，然后使用面向对象的编程语言进行表达的过程
- 面向对象编程是软件产业化发展的需求
- 理解面向对象的思想精髓（封装、多态、继承），至少掌握一种编程语言

- 对象主要指现实生活中客观存在的实体，在java语言中体现为内存空间中的一块存储区域
- 类简单来说就是分类，是对具有相同特征和行为的多个对象共性的抽象描述，在java语言中体现为一种引用数据类型，里面包含了描述特征/属性的成员变量以及描述行为的成员方法
- 类是用于构建对象的模板，对象的数据结构由定义他的类来决定

### 类的定义

```java
class [类名]{
    类体;
}

class Person{
    
    public static void main(String arsg){
        
    }
}
```

规范：每个单词首字母大写

### 成员变量的定义

```java
class [类名]{
    [数据类型] [成员变量名] = [初始值];
}

class Person{
    int age = 3;
}
```

规范：第二个单词开始首字母大写

### 对象的创建

```java
new [类名]();

new Person();
```



1. 当一个类定义完毕之后，可以使用new关键字来创建该类的对象，这个过程叫做类的实例化
2. 创建对象的本质就是在内存空间的堆区申请一块存储区域，用于存放该对象独有特征信息

#### 引用的定义

基本概念

1. 使用引用数据类型定义的变量叫做引用型变量，简称引用
2. 引用变量主要用于记录在对象在堆区中的内存地址信息，便于下次访问

语法格式

```java
[类名] [引用变量名] = new [类名]();
[引用变量名].[成员变量名];

Person person = new Person();
String name = person.name;
System.out.print(name);
```

### 成员方法的定义

```JAVA
class [类名]{
    [返回值类型] [成员方法名]([形参列表]){
        成员方法体;
    }
}

class Person{
    void show(){
        System.out.print("秀");
    }
}
```

规范：第二个单词开始首字母大写

#### 返回值类型的详解

- 从方法体内返回到方法体外的数据内容

- 返回值类型主要指返回值的数据类型，可以是基本数据类型，也可以是引用数据类型

  `当返回的数据内容是66，则返回值类型int即可`

- 在方法体中使用return关键字可以返回具体的数据内容并结束方法

  `return 66;`

- 当方法不需要返回任何数据类型时，返回值写void

#### 形参列表的详解

- 形式参数主要用于将方法体外的数据内容带入到方法体内部

- 形式参数主要指多个形式参数组成的列表

  `[数据类型] [形参变量名1],[数据类型] [形参变量名2]`

#### 方法体的详解

- 成员方法体主要用于编写描述该方法功能的语句块
- 成员方法可以实现代码的重用，简化代码

##### 方法的调用

```java
[引用变量名].[成员方法名]([实参列表]);

Person p = new Person();
p.show(66,77);
```

- 实际参数列表主要用于对形式参数列表进行初始化操作，因此参数的个数、类型以及顺序都要完全一致
- 实际参数可以传递直接量、变量、表达式、方法的调用等

##### 可变长参数

1. 语法格式

  ```java
[返回值类型] [方法名]([参数的类型...] [参数名])

void person(int... a){
    System.out.println(a[0]);
}
  ```

2. 方法的参数部分指定参数的个数是可以改变的，也就是0~n个

3. 一个方法的形参列表中最多只能声明一个可变参数，并且最多一个

##### 方法传参过程

```java
int max(int ia,int ib){... ...}

public static void main(String[] args){
    int a = 5;
    int b = 6;
    int res = m.max(a,b);
}
```

1. 为main方法中的变量a、b、res分配空间并初始化
2. 调用max方法，为max方法的形参变量ia、ib分配空间
3. 将实参变量的数值赋值到形参变量的内存空间中
4. max方法运行完毕后返回，形参变量空间释放
5. main方法中的res变量得到max方法的返回值
6. main方法结束后释放相关变量的内存空间

##### 传参的相关概念

1. 参数分为形参和实参，定义方法时的参数叫形参，调用方法时传递的参数叫实参

2. 调用方法时采用值传递把实参传递给形参，方法内部其实是在使用形参

3. 所谓值传递就是当参数是基本类型时，传递参数的值

   ```java
   比如传递 i = 10; 是把10赋值给了形参
   ```

   当参数是对象时，传递的是对象的值，也就是把对象的地址赋值给形参


##### 注意事项

1. 基本数据类型变量作为方法的参数传递时，形参变量数值的改变通常不会影响到实参变量的数值，因为两个变量有各自独立的内存空间

   ```java
   void max(int ia){
   	ia = 100;
       System.out.println(ia);
   }
   
   public static void main(String[] args){
       int ia = 5;
       m.max();
       System.out.println(ia);
   }
   
   结果: 
   100
   5
   ```

2. 引用数据类型的变量作为方法的参数传递时，形参变量指向内容的改变会影响到实参变量指向内容的数值，因为两个变量指向同一块内存空间

   ```java
   void max(int[] ia){
   	ia[0] = 100;
       System.out.println(ia[0]);
   }
   
   public static void main(String[] args){
       int[] ia = new int[]{5};
       m.max();
       System.out.println(ia[0]);
   }
   
   结果: 
   100
   100
   ```

3. 引用数据类型的变量作为方法的参数传递时，若形参变量改变指向后再改变内容，形参变量指向内容的改变不会影响到实参变量指向内容的数值，因为两个变量指向不同的内存空间

   ```java
   void max(int[] ia){
   	ia[0] = new int[]{100};
       System.out.println(ia[0]);
   }
   
   public static void main(String[] args){
       int[] ia = new int[]{5};
       m.max();
       System.out.println(ia[0]);
   }
   
   结果: 
   100
   5
   ```

### 内存结构之栈区

1. 栈用于存放程序运行过程中所有的局部变量，一个java程序从开始到结束会有多次方法的调用
2. JVM会为每个方法的调用在栈中分配一个对应的空间，这个空间称为该方法的栈帧，一个栈帧对应一个正在调用的方法，栈帧中存储了改方法的参数、局部变量等数据
3. 等一个方法结束后，对应的栈帧将被清除

### 构造方法的基本概念

1. 声明构造方法

  ```java
  class [类名]{
   	[类名]([形参列表]){
       	构造方法体;
   	}
  }
  
  class Person{
      Person(){
          System.out.println("构造方法");
      }
  }
  ```

2. 构造方法名与类名完全相同并且没有返回值类型，连void都不许有
3. 当一个类中没有定义任何构造方法时，编译器会自动添加一个无参空构造方法，叫做默认/缺省构造方法
4. 如果类中出现了构造方法，则编译器不再提供任何形式的构造方法

### 方法重载的概念

1. 若方法名称相同，参数列表不同，这样的方法之间构成重载关系（Overload）
2. 方法重载的主要形式体现在：参数的个数不同、参数的类型不同、参数的顺序不同，与返回值和形参变量名无关，但建议返回值类型最后相同
3. 判断方法是否能构成重载的核心：调用方法时是否能加以区分

### this的基本概念

1. 若在构造方法中出现了this关键字，则代表当前正在构造的对象
2. 若在成员方法中出现了this关键字，则代表当前正在调用的对象
3. this关键字本质上就是当前类类型的引用变量
4. 在构造方法中和成员方法中访问成员变量是，编译器会加上`this.`前缀，而`this.`相当于汉语中我的，当不同的对象调用同一个方法时，由于调用方法的对象不同导致this关键字不同，从而`this.`方式访问的结果也就随之不同
5. 当局部变量名与成员变量名相同时，在方法体中会优先使用局部变量（就进原则），若希望使用成员变量，则需要在成员变量前面加上`this.`的前缀，明确要求该变量是成员变量
6. this关键字除了可以通过`this.`的方式调用成员变量和成员方法为，还可以作为方法的返回值
7. 在构造方法的第一行可以使用this()的方式来调用本类中其他构造方法

#### 常见错误

1. 引用类型变量用于存放对象的地址，可以给引用类型赋值为null，表示不指向任何对象

2. 当某个引用类型变量为null时无法对对象实施访问（因为它没有指向任何对象）

   此时，如果通过引用访问成员变量或调用方法，会产生NullPointerException异常

### 递归的基本概念

1. 在方法体内调用自身就叫做递归
2. 使用递归必须有递归的规律以及退出条件
3. 使用递归必须使得问题简单化而不是复杂化
4. 若递归影响到程序的执行性能，则使用递推取代之

### 封装的概念

1. 通常情况下可以在测试类给成员变量赋值一些合法但不合理的数值，无论是编译简单还是运行阶段都不会报错或者给出提示，此时与现实生活不符
2. 为了避免上诉错误的发生，就需要对成员变量进行密封包装处理，来隐藏成员变量的细节以及保证成员变量数值的合理性，该机制就叫做封装

### 封装的实现流程

1. 私有化成员变量，使用private关键字修饰
2. 提供公有的get和set方法，并在方法体中进行合理值的判断
3. 在构造方法中也要带set方法进行合理值的判断

### JavaBean概念

1. JavaBean是一种Java语言写成的可重用组件，其他Java类可以通过反射机制发现和操作这些JavaBean的属性

2. JavaBean本质上就是符合以下标准的java类

   类是公共的

   有一个无参的公共构造器

   有属性且有对应的get/set方法

### static关键字

- 使用static关键字修饰成员变量表示静态的含义，此时成员变量由对象层级提升为类层级，也就是整个类只有一份并被所以对象共享，该成员变量随着类的加载准备就绪，与是否创建对象无关
- static关键字修饰成员可以使用**引用.**的方式访问，但推荐使用**类名.**的方式访问
- 在非静态成员方法中既能访问非静态的成员又能访问静态的成员
- 在静态成员方法中只能访问静态成员不能访问非静态成员
- 在以后的开发中，只有隶属于类层级并被所以对象共享的内容才可以使用static关键字修饰

### 构造块和静态代码块

- 构造块：在类体中直接使用{}括起来的代码块
- 当需要在执行构造方法体之前做一些准备工作时，则将准备工作的相关代码写在构造块中即可
- 每创建一次对象，都会执行一次构造块
- 静态代码块：使用static关键字修饰的构造块
- 静态代码块会随着类的加载准备就绪，会先于构造块执行，静态代码块只会执行一次
- 当需要随着类的加载做一些准备工作时，使用静态代码块
- 先执行父类静态代码块，再执行子类代码块
- 执行父类的构造块，执行父类的构造方法体
- 执行子类的构造块，再执行子类的构造方法体

### 单例设计模式

```java
public class SingLeton{
    private static SingLeton = new SingLeton();// 饿汉式
    // private static SingLeton = null; // 懒汉式
    private SingLeton(){}
    public static SingLeton getSingLeton(){
        if (null == sin){
            sin = new SingLeton();
        }
        return sin;
    }
}
```

- 对外提供且只提供一个对象
- 私有化构造方法，使用private关键字修饰
- 声明本类类型的引用，指向本类类型的对象，并使用private static关键字修饰
- 提供公有的get方法负责将对象返回出去，并使用public static关键字共同修饰

### 继承

- 当多个类之间有相同的特征和行为时，可以将相同的内容提取出来组成一个公共类，让多个类吸收公共类中已有特征和行为而在多个类型只需要编写自己独有特征和行为的机制叫做继承

- 在java中使用extends关键字来表示继承关系

  ```java
  class tests extends test{
      
  }
  ```

- 使用继承提高了代码的复用性，可维护性及扩展性，是多态的前提

- 子类不能继承父类的构造方法和私有方法，私有变量可以被继承但是不能访问

- 无论用何种方式构建子类对象时都会自动调用父类无参构造方法来初始化从父类中继承的成员变量，相当于在构造方法的第一行增加代码super()的效果

- 使用继承必须满足逻辑关系，子类 is a 父类，不能滥用继承

- java中只支持单继承，不支持多继承，父类可以拥有多个子类，子类只能拥有一个父类

#### 方法的重写

- 修饰符，返回值，方法名，参数列表完全相同
- 从java5开始可以返回子类类型
- 方法的访问权限不能变小，可以相同或者变大
- 要求方法不能抛出更大的异常

#### 常用的访问修饰符

|  修饰符   |   本类   | 同一个包中的类 |   子类   |  其他类  |
| :-------: | :------: | :------------: | :------: | :------: |
|  public   | 可以访问 |    可以访问    | 可以访问 | 可以访问 |
| protected | 可以访问 |    可以访问    | 可以访问 | 不能访问 |
|   默认    | 可以访问 |    可以访问    | 不能访问 | 不能访问 |
|  private  | 可以访问 |    不能访问    | 不能访问 | 不能访问 |

- public可以在任意类使用
- private修饰的成员只能在本类中使用
- 通常情况下，成员方法都用public关键字修饰，成员变量都使用private关键字修饰

#### 包的定义

- 定义类时需要指定类的名称，但是如果仅仅将类名作为类的唯一标识，则不可避免的出现命名冲突的问题，这会给组件复用以及团队间的合作造成很大的麻烦

- 在java语言中用包（package）的概念来解决命名冲突的概念

  ```java
  package 包名;
  package 包名1.包名2.包名3;
  ```

- 一般包名使用域名的反写

- 使用import关键字导入包
- 使用import关键字可以导入静态成员（java 5.0后）

#### final

- final本意为`最终的，不可改变的`，可以修饰类、成员方法以及成员变量
- final关键字修饰类体现在该类不能被继承
- final关键字修饰成员方法体体现在该方法不能被重写但可以被继承
- final关键字修饰成员变量体现在该变量必须初始化且不能改变

##### 常量

- 在以后的开发中很少单独使用final关键字来修饰成员变量，通常使用`public static final`关键字共同修饰成员变量来表达常量的含义，常量的命名规范要求是所有字母大写，不同的单词之间采用下划线连接

### 多态

- 同一种事务表现的多种形态

  ```java
  父类类型 引用变量名 = new 子类类型();
  ```

- 当父类类型的引用指向子类对象时，父类类型的引用可以直接调用父类独有的方法
- 当父类类型的引用指向子类类型的对象时，父类类型的引用不可以直接调用子类独有的方法
- 对于父子类都有的非静态方法来说，编译阶段调用父类版本，运行阶段调用子类重写的版本（动态绑定）
- 对于父子类都有的静态方法来说，编译和运行阶段都调用父类版本

#### 引用数据类型之间的转换

- 引用数据类型之间的转换方式有两种：自动类型转换和强制类型转换

- 自动类型转换主要是指小类型向大类型的转换，也就是子类转为父类，也叫做向上转型

- 强制类型转换主要指大类型到小类型的转换，也就是父类转子类，也叫做向下转型或显式类型转换

- 若强转的目标类型并不是该引用真正指向的数据类型时则编译通过，运行阶段发生类型转换异常

- 为了避免上诉错误的发生，应该在强转之前进行判断

  ```java
  if(引用变量 instanceof 数据类型)
  ```

  判断引用变量指向的对象是否为后面的数据类型

#### 多态的实际意义

- 多态的实际意义在于屏蔽不同子类的差异性实现通用的编程带来不同的效果

### 抽象方法

- 抽象方法主要指不能具体实现方法并且使用abstract关键字修饰，也就是没有方法体

  ```java
  访问权限 abstract 返回值类型 方法名(形参列表)
  public abstract void cry();
  ```

### 抽象类

- 抽象类主要指不能具体实例化的类并且使用abstract关键字修饰，也就是不能创建对象

  ```java
  访问权限 abstract class 类名{}
  public class abstract cry{}
  ```

- 抽象类中可以有成员变量、构造方法、成员方法

- 抽象类可以没有抽象方法，也可以有抽象方法

- 拥有抽象方法的类必须是抽象类

- 真正意义上的抽象类应该是具有抽象方法并用abstract关键字修饰的类

#### 抽象类的意义

- 抽象类的实际意义不在于自身创建对象而在于被继承
- 当一个类继承抽象类后必须重写抽象方法，否则该类也会变成抽象类，也就是该抽象类对子类具有强制性和规范性，因此叫做模板设计模式

#### 常见错误

```java
private abstract void test(); // private 和 adstract不能共存 无法继承的抽象方法没有意义
public final abstract void test();// final修饰不能被重写 同上 无意义
public static abstract void test();// 通过类名就可直接调用，抽象类不能创建对象的意义就不存在了
```

### 接口

- 接口就是一种比抽象类还抽象的类，体现在所有方法都是抽象方法
- 定义类的关键字是class，定义接口的关键字是interface
- 从jdk1.9开始允许接口中出现私有方法

