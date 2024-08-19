package com.example.climatehopefund_trial1;

public class User {
    public String Username;
    public String Email;
    public String Name;
    public String Number;
    public String Password;
    public String ConfirmPassword;
    public String User_cardNumber;
    public String cardExpiry_date;
    public String cardCvv_number;

    public User() {
    }

    public User(String Username, String Email, String Name, String Number, String Password, String ConfirmPassword, String User_cardNumber,
                String cardExpiry_date, String cardCvv_number ) {
        this.Username = Username;
        this.Email = Email;
        this.Name = Name;
        this.Number = Number;
        this.Password = Password;
        this.ConfirmPassword = ConfirmPassword;
        this.User_cardNumber = User_cardNumber;
        this.cardExpiry_date = cardExpiry_date;
        this.cardCvv_number = cardCvv_number;
    }
}
