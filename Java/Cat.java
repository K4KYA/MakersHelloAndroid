// Class declaration - name must match file name (Cat.java)
public class Cat {
  
  /* 
    Instance variable - uninitialised
    private means this variable can only be accessed inside this class
  */
  private String mName;
  
  // Class constructor - no return type, name matches class name
  public Cat(String name){
    this.mName = name;
  }
  
  /*
    Setter to modify private name variable
    void means no return type
  */
  public void setName(String newName){
    mName = newName;
  }
  
  /* 
    Instance method - can only be called on a valid Cat object  
    (after calling new Cat("name"); )
  */
  public String speak(){
    return "My name is "+mName;
  }
  
  // Class method - can be called without creating a new Cat object 
  public static String says(){
    return "Meow!";
  }
  
  public static void main(String[] args) {
    System.out.println(Cat.says());
    Cat nyan = new Cat("nyan");
    System.out.println(nyan.speak());
    nyan.setName("fluffy");
    System.out.println(nyan.speak());
  }
  
}



