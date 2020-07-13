// 设计学生类 测试正确覆盖equals方法 应用到算法中
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    // equals比较默认是两个类对象的地址，重写实现比较字符串
//    public boolean equals(Student student) { }
    // equals是Object父类的函数 覆盖方法，函数签名要与父类的函数签名保持一致 传入Object
    @Override
    public boolean equals(Object student) {
        // 先看一看当前类对象是否为Student类对象
        if (this == student)
            return true;
        if (this == null)
            return false;
        // 判断强制转换是否成立 拿到当前的类对象所对应的类是否等于传来类对象所对应的类
        if (this.getClass() != student.getClass())
            return false;
        // 传来不为空且是Student对象，则进行强制转换，将学生类的比较转换成字符串的比较
        Student another = (Student) student;
        return this.name.toLowerCase()
                .equals(another.name.toLowerCase()); // 忽略大小写
    }
}
