import java.util.*;

class account{
    private String name;
    private int age;
    private char gender;
    private String perAddress;
    private String phoneNo;
    private String Occupation;
    private String aadharNo;
    private String username;
    private String password;
    private String prefSeat;
    private String prefCities;
    private String type_of_Seat;//Buisness or Economy....
    account(String name,int age,char gender,String perAddress,String phoneNo,String Occupation,String aadharNo,String username,String password){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.perAddress = perAddress;
        this.phoneNo = phoneNo;
        this.Occupation = Occupation;
        this.aadharNo = aadharNo;
        this.username = username;
        this.password = password;
    }
    void set_username(String Username){
        this.username = Username;
    }
    void set_password(String Password){
        this.password = Password;
    }
    String get_password(){
        return password;
    }
    String get_username(){
        return username;
    }
    void set_pref_cities(String city){
        this.prefCities = city;
    }
    void set_pref_seat(String seat){
        this.prefSeat = seat;
    }
    String get_prefCities(){
        return this.prefCities;
    }
    String get_prefSeat(){
        return this.prefSeat;
    }
    void get_people(){//Usual Traveller

    }
}
class dataBase{
    private ArrayList<account>DB = new ArrayList<account>();
    private account dummy = new account("-1",'1','-',"-1","-1","-1","-1","-1","-1");
    private account a1 = new account("Prathik",20,'M',"Rajnagar,Hubli","8123501417","Student","985565615366","prathik8794","prathik_8794");
    private account a2 = new account("Sirish",20,'M',"OmpStreet,Banglore","9846598645","Student","66554489558","Sirish8194","sir_794");
    private account a3 = new account("Surya",20,'M',"TitanStreet,Chennai","9638527410","Student","2685596565665","surya87094","sv_8942");
    private account a4 = new account("Ram",20,'M',"CourtCircle,Hubli","8271934560","Student","656565655959","ram87958","rm_18794");
    private account a5 = new account("Yash",20,'M',"RRJ,Kota","9032165487","Student","61865298826489","yass85794","ysh_870594");
    void init_account(){
        DB.add(a1);
        DB.add(a2);
        DB.add(a3);
        DB.add(a4);
        DB.add(a5);
    }
    account get_Account(account a1){
        for(int i=0;i<DB.size();i++){
            if(a1.equals(DB.get(i)))return DB.get(i);
        }
        return dummy;
    }
    void add_Account(account a1){
        DB.add(a1);
    }
    void remove_Account(account a2){
        for(int i=0;i<DB.size();i++){
            if(a2.equals(DB.get(i)))DB.remove(i);
        }
        System.out.println("Account can't be removed because it do not exist!!");
    }
    account search_account(String username,String password){
        for(int i=0;i<DB.size();i++){
            if(DB.get(i).get_username().equals(username) && DB.get(i).get_password().equals(password)){
                return DB.get(i);
            }
        }
        return dummy;
    }
}
class Flight{
    private String from;
    private String to;
    private String dateOfDeparture;
    private String dateOfArrival;
    private String timeOfArrival;
    private String timeOfDeparture;
    private int no_seats;// for testing 10 
    private int no_economic_seats; // for testing 5
    private char[] seats_economic = new char[5];
    private int no_buisness_seats; // for testing 5
    private char[] seats_buisness = new char[5];
    Flight(String from,String to,String dateOfDeparture,String dateOfArrival,String timeOfArrival,String timeOfDeparture,int no_seats,int no_economic_seats,int no_buisness_seats){
        this.from = from;
        this.to = to;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
        this.timeOfDeparture = timeOfDeparture;
        this.no_seats = no_seats;
        this.no_economic_seats = no_economic_seats;
        this.no_buisness_seats = no_buisness_seats;
        this.seats_economic = "_____".toCharArray();
        this.seats_buisness = "_____".toCharArray();
    }
    void show_status_of_seats(){
        // * for filled and _ for empty
        System.out.println("Economic class:   ");
        for(int i=0;i<5;i++)System.out.print(seats_economic[i]+" ");
        System.out.println();
        System.out.println("Buisness class:   ");
        for(int i=0;i<5;i++)System.out.print(seats_buisness[i]+" ");
        System.out.println();
    }
    void if_seat_booked_economic(int seat_no){
        seats_economic[seat_no] = '*';
    }
    void if_seat_booked_buisness(int seat_no){
        seats_buisness[seat_no] = '*';
    }
}
public class db_Domsetic{
    private ArrayList<Flight>db = new ArrayList<Flight>();
    Flight F1 = new Flight("Chennai","Banglore","27/11/2021","27/11/2021","10:40","12:00",5,5,5);
}
public class Main{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        dataBase db = new dataBase();
        db.init_account();
        System.out.println("Welcome to the AirLine");
        System.out.println("1. Login");//press 1 to login and 2 to create new Account
        System.out.println("2. New User");
        int process = s.nextInt();
        if(process == 1){
            //while loop till password and username matches and only max 3 times the password can be wrong......
            System.out.println("UserName: ");
            String UserName = s.next();
            System.out.println("Password: ");
            String Password = s.next();
            account present  = db.search_account(UserName,Password);
            if(present.get_username().equals("-1")){
                System.out.println("Invalid Account!!!");
                System.out.println("Please Retry!!!");
                // calling Login page again for the user
            }
            else{
                //If the password matches it will allow customer to book the ticket
                System.out.println("1.Domestic");
                System.out.println("2.International");
                int mode = s.nextInt();
                if(mode == 1){
                    //No need of passport 
                    String[] cities = {"Ahmedabad","Banglore","Chennai","Delhi","Goa","Indore","Jodhpur","Kolkota","Mumbai","Ooty"};
                    System.out.println("From:");
                    for(int i=0;i<cities.length;i++)System.out.println(i+" "+cities[i]);
                    String from = s.next();
                    System.out.println("To:");
                    for(int i=0;i<cities.length;i++){
                        if(!cities[i].equals(from)){
                        System.out.println(i+" "+cities[i]);
                        }
                    }
                    String to = s.next();
                }
                else{
                System.out.println("From: ");
                String from = s.next();
                System.out.println("To: ");
                String to = s.next();
                }
                }
        }
        else{
            System.out.println("Name: ");
            String name = s.next();
            System.out.println("Age: ");
            int age = s.nextInt();
            System.out.println("Gender: ");
            char gender = s.next().charAt(0);
            System.out.println("Permanent Address: ");
            String address = s.next();
            System.out.println("PhoneNumber: ");
            String phoneNo = s.next();
            System.out.println("Occupation: ");
            String occupation = s.next();
            System.out.println("AadharNumber: ");
            String aadharNo = s.next();
            System.out.println("Enter the Username: ");
            String username = s.next();
            System.out.println("Enter the Password: ");
            String password = s.next();
            account new_Account = new account(name,age,gender,address,phoneNo,occupation,aadharNo,username,password);
            db.add_Account(new_Account);
        }
    }
}