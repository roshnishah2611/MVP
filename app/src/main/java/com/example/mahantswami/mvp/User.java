package com.example.mahantswami.mvp;

public class User
{
    private String fullname="",email="",password="";
    public String error="";
    private boolean checked=false;

    public User()
    {}
    public User(String fullName,String email,String password)
    {
        this.fullname=fullName;
        this.email=email;
        this.password=password;
    }
    public String getFullname()
    {
        return fullname;
    }
    public void setFullName(String fullName)
    {
        this.fullname=fullName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
        checkPassword();
    }
    public void checkPassword()
    {
        System.out.println(password);
        if(password.length()<8)
            checked=false;
        else
        {
            int s=0,u=0,d=0;
            for(int i=0;i<password.length();i++)
            {
                if(password.charAt(i)=='@' || password.charAt(i)=='!' || password.charAt(i)=='#' || password.charAt(i)=='$' || password.charAt(i)=='%' || password.charAt(i)=='^' || password.charAt(i)=='&' || password.charAt(i)=='*')
                    s++;
                else if((int)password.charAt(i)>=65 && (int)password.charAt(i)<=90)
                    u++;
                else if((int)password.charAt(i)>=48 && (int)password.charAt(i)<=57)
                    d++;
            }
            if(s>0 && d>0 && u>0)
                checked=true;
            else
                checked=false;
        }
        if(!checked)
            error="Password must contain \n" +
                    "One Uppercase Alphabet(A-Z)\n"+
                    "One Digit (0-9)\n"+
                    "One Special Symbol(!@#$%^&*)\n"+
                    "Length must be minimum 8 Characters";
        else
            error="";
    }
    @Override
    public String toString() {
        return "Full Name : " + getFullname() + ",\nEmail : " + getEmail();
    }
}