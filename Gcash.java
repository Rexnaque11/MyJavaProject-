import java.util.Scanner;

public class Gcash {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     
     double BalanceAccount = 0;
     int CorrectPassword = 2006;
     int pin;
     
    do{
         System.out.print("Enter your MPIN: ");
         pin = sc.nextInt();
    if(pin != CorrectPassword){
        System.out.println("Invalid Pin. Please Try Again. ");
    }     
     }while(pin != CorrectPassword);
    
    char choice;
    do{
        System.out.println("\n----- Enter a number for Operation. ----- ");
        System.out.println("1 for Cash-In "+ "\n2 for Cash-Out"+ "\n3 for Buy Load with Promos"+ "\n4 for But Regular Load"+ "\n5 for Exit");
        int operation = sc.nextInt();
        sc.nextLine();
        
    switch(operation){
        case 1:
          char choice1;
            do{
                System.out.println("Enter Amount to Cash-In ");
                int cashin = sc.nextInt();
                sc.nextLine();
            if(cashin <= 0){
                System.out.println("Error. Invalid Amount ");   
            }else{
               double cashinFee = cashin * 0.02;
               double gcashin = cashin - cashinFee;
               BalanceAccount += gcashin;
                System.out.println("You have recieve PHP " + cashin + "(cashinfee used): PHP " + cashinFee);
                System.out.println("Your Balance: PHP " + BalanceAccount);
            }
                System.out.println("Do you want to cash-in again? y/n? ");
                choice1 = sc.nextLine().charAt(0);
            }while (choice1 == 'y' || choice1 == 'Y');
            break;
            
        case 2:
          char choice2;
            do{
                System.out.println("Account Balance: PHP " + BalanceAccount);
                System.out.println("Enter Amount to Cash-Out");
                int amount = sc.nextInt();
                sc.nextLine();
            if(amount <= 0 ){
                System.out.println("Error. Invalid Amount ");
            }else{
              if(amount <= BalanceAccount){
               double cashoutFee = amount * 0.02;
               double gcashout = amount - cashoutFee;
               BalanceAccount -= amount;
                  System.out.println("You have sent PHP " + amount + "(cashoutfee used: " + cashoutFee);
                  System.out.println("Cash-Out amount: PHP " + gcashout);
                  System.out.println("Your Balance: PHP " + BalanceAccount);
              }else{
                  System.out.println("Insufficient Funds! ");
              }
            }
                System.out.println("Do you want to cash-out again? y/n? "); 
                choice2 = sc.nextLine().charAt(0);
            }while (choice2 == 'y' || choice2 == 'Y');
            break;
            
        case 3:
          char choice3;
            do{
                System.out.println("==== Enter a Number ==== ");
                String number = sc.nextLine();
             while (!number.matches("(09\\d{9}|\\+63\\d{9})")){
                    System.out.println("Invalid Phone Number! Please enter a valid phone number."); 
                    number = sc.nextLine(); 
                }
                int[] promoPrices = {50, 15, 20, 70};
                String[] promoDetails = {" EasySURF50 FunALIW 9GB data valid for 3 days ", 
                 " FBML15 1GB data for Facebook and Mobile Legends valid for 3 days ", 
                 " AN20 Unli call & text to all networks valid for 2 days ",
                 " EasySURF70 FunALIW 9GB data valid for 7 days "};
                    System.out.println(" \n>>>>> Select Promo: <<<<< ");
                for (int i = 0; i < promoDetails.length; i++) {
                    System.out.println((i + 1 ) + " for " + promoDetails[i]);
                     } 
                    int promo = sc.nextInt();
                    sc.nextLine();
                 
            if(promo >= 1 && promo <= promoPrices.length){
                int loadAmount = promoPrices[promo - 1];
                String promoDetail = promoDetails[promo - 1];
              if(loadAmount > BalanceAccount){
                  System.out.println("Insufficient Funds to but PHP " + loadAmount + " load ");
              }else {
                  BalanceAccount -= loadAmount;
                  System.out.println("Naka register kana sa " + promoDetail + "loaded to "  + number +"." );
                  System.out.println("Your Balance: PHP " + BalanceAccount);
              }
            }
                System.out.println("Do you want to buy another promo? y/n? ");
                choice3 = sc.nextLine().charAt(0);
            }while (choice3 == 'y' || choice3 == 'Y');
            break;
        
        case 4:
          char choice4;
            do{
                System.out.println("Enter a Number ");
                String regnum = sc.nextLine();
               while(!regnum.matches("(09\\d{9}|\\+63\\d{9})")){
                System.out.println("Invalid Phone Number! Please enter a valid phone number.");
                regnum = sc.nextLine();
               
                }
                System.out.println("\n>>>>> Enter amount of load you want to buy <<<<< ");
                double regularLoad = sc.nextDouble();
                sc.nextLine();
                
            if(regularLoad <= 0){
                System.out.println("Error. Invalid Load Amount ");
            }else if(regularLoad > BalanceAccount){
                System.out.println("Insufficient Funds to buy PHP " + regularLoad + " load. ");
            }else{
                BalanceAccount -= regularLoad;
                System.out.println(regularLoad + " has been loaded to your mobile number " + regnum);
                System.out.println("Your Balance: PHP " + BalanceAccount);
            }
                System.out.println("Do you want to buy more load? y/n? ");
                choice4 = sc.nextLine().charAt(0);
            }while(choice4 == 'y' || choice4 == 'Y');
            break;
        case 5:
            System.out.println("Exiting..... Thank You! ");
            break;
        default:
            System.out.println("Invalid Operation. Please choose again ");  
    }
        if(operation != 5){
             System.out.println("Do you want to perform another operation? y/n? ");
        choice = sc.nextLine().charAt(0);
        }else{
            choice = 'r';
        }
    }while (choice == 'y' || choice == 'Y');
     
    }
    
}
