/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledemo;

/**
 *
 * @author alexandra.vaschillo
 */
public class MyClass {
    private int a;
    private Rectangle r;
    
    public MyClass()
    {
        a = 0;
        r = new Rectangle();
    }
    // deep copy!!!!
    public MyClass(MyClass obj)
    {
        this.a = obj.a;
        this.r = new Rectangle(obj.r);//copy constructor call
    }
    public boolean equals(MyClass obj)
    {
        if(this.a == obj.a  
               && this.r.getLength()==obj.r.getLength()
               && this.r.getWidth()==obj.r.getWidth()) return true;
        else return false;
    }
    public void setA(int k)
    {
        a =k;
    }
    public int getA()
    {
        return a; 
    }
    public Rectangle getR()
    {
        return new Rectangle(r);
    }
    public double getRLength()
    {
        return r.getLength();
    }
}
