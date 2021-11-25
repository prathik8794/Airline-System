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
    private int base_price;
    Flight(String from,String to,String dateOfDeparture,String dateOfArrival,String timeOfArrival,String timeOfDeparture,int no_seats,int no_economic_seats,int no_buisness_seats,int base_price){
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
        this.base_price = base_price;
    }
    void change_in_base_price(){
        this.base_price+=300;
    }//Nearer to date of flight the price goes on increasing by 300Rs.
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
    String get_from(){
        return this.from;
    }
    String get_to(){
        return this.to;
    }
    void print_details(){
        System.out.println(from+" "+to+" "+base_price+"Rs "+dateOfDeparture+" "+dateOfArrival+" "+timeOfDeparture+" "+timeOfArrival);
    }
}
 class db_Domsetic{
    private ArrayList<Flight>db = new ArrayList<Flight>();
    Flight F1 = new Flight("Chennai","Banglore","27/11/2021","27/11/2021","10:40","12:00",5,5,5,3000);
    Flight F2 = new Flight("Chennai","Banglore","27/11/2021","27/11/2021","17:00","18:20",5,5,5,3600);
    Flight F3 = new Flight("Ahmedabad","Banglore","27/11/2021","27/11/2021","9:40","11:00",5,5,5,4100);
    Flight F4 = new Flight("Delhi","Banglore","27/11/2021","27/11/2021","23:40","2:00",5,5,5,5060);
    Flight F5 = new Flight("Mumbai","Banglore","27/11/2021","27/11/2021","22:00","23:40",5,5,5,2360);
    Flight F6 = new Flight("Kolkota","Banglore","27/11/2021","27/11/2021","8:00","10:00",5,5,5,4350);
    Flight F7 = new Flight("Banglore","Chennai","27/11/2021","28/11/2021","3:40","5:00",5,5,5,3000);
    //db is always maintained in increasing price of flight......
    void init_db(){
        db.add(F1);
       // F1.print_details();
        db.add(F2);
        db.add(F3);
        db.add(F4);
        db.add(F5);
        db.add(F6);
        db.add(F7);
       // db.add(F8);
       // db.add(F9);
    }
    void add_flight(Flight f){
        db.add(f);
    }
    void remove_flight(Flight f){
        for(int i=0;i<db.size();i++){
            if(f.equals(db.get(i)))db.remove(i);
        }
        System.out.println("flight can't be removed because it do not exist!!");
    }
    void search_flight(String from,String to){
        int j=0;
        for(int i=0;i<db.size();i++){
            if(from.equals(db.get(i).get_from()) && to.equals(db.get(i).get_to()) ){
                System.out.print(j+1+" ");
                db.get(i).print_details();
                j++;
            }
            //else System.out.println("0");
        }
    }
}
class db_International{
    private ArrayList<Flight>db1 = new ArrayList<Flight>();
    Flight f1 = new Flight("Chennai","Abu-dabhi","27/11/2021","28/11/2021","10:40","23:00",5,5,5,150000);//all will be in Indian price but allowed to pay in different countries currencies.....
    Flight f2 = new Flight("LA","Delhi","27/11/2021","28/11/2021","17:00","19:20",5,5,5,35600);
    Flight f3 = new Flight("Paris","London","28/11/2021","29/11/2021","9:40","11:00",5,5,5,91000);
    Flight f4 = new Flight("Chicago","Banglore","27/11/2021","29/11/2021","23:40","2:00",5,5,5,455060);
    Flight f5 = new Flight("Mumbai","Banglore","27/11/2021","27/11/2021","22:00","23:40",5,5,5,2360);
    Flight f6 = new Flight("Kolkota","Banglore","27/11/2021","27/11/2021","8:00","10:00",5,5,5,4350);
    Flight f7 = new Flight("Banglore","Chennai","27/11/2021","28/11/2021","3:40","5:00",5,5,5,3000);
    //db is always maintained in increasing price of flight......
    void init_db(){
        db1.add(f1);
       // F1.print_details();
        db1.add(f2);
        db1.add(f3);
        db1.add(f4);
        db1.add(f5);
        db1.add(f6);
        db1.add(f7);
       // db.add(F8);
       // db.add(F9);
    }
    void add_flight(Flight f){
        db1.add(f);
    }
    void remove_flight(Flight f){
        for(int i=0;i<db1.size();i++){
            if(f.equals(db1.get(i)))db1.remove(i);
        }
        System.out.println("flight can't be removed because it do not exist!!");
    }
    void search_flight(String from,String to){
        int j=0;
        for(int i=0;i<db1.size();i++){
            if(from.equals(db1.get(i).get_from()) && to.equals(db1.get(i).get_to()) ){
                System.out.print(j+1+" ");
                db1.get(i).print_details();
                j++;
            }
            //else System.out.println("0");
        }
    }
}
public class Main{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        dataBase db = new dataBase();
        db_Domsetic d1 = new db_Domsetic();
        db_International d2 = new db_International();
        d1.init_db();
        d2.init_db();
        db.init_account();
        Random random = new Random();   
        //d1.search_flight("Chennai","Banglore");
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
                    System.out.println(from+":"+to);
                    d1.search_flight(from,to);
                    System.out.println("1.Choose a flight");
                    //System.out.println("2.Logout");
                    int next_mode = s.nextInt();
                    System.out.println("1.Buisness   2.Economic");
                    int be = s.nextInt();
                    System.out.println("Any Co-passenger: ");//need to press Y if yes N for no...
                    char c = s.next().charAt(0);
                    if(c=='N'){
                        System.out.println("Name: "+UserName);
                        System.out.println("TicketNumber:"+from.substring(0,3)+":"+to.substring(0,3)+""+random.nextInt(10));
                        if(be==1)System.out.println("Buisness");
                        else System.out.println("Economic");
                        System.out.println("Price:");
                        int price = s.nextInt();
                        System.out.println("Payment Modes:");
                        System.out.println("1.Debit Card");
                        System.out.println("2.Credit Card");
                        System.out.println("3.NET Banking");
                        int p_m = s.nextInt();
                        if(p_m == 1)System.out.println("Payed Using the Debit Card");
                        else if(p_m==2)System.out.println("Payed Using the Credit Card");
                        else System.out.println("Paid through Bank");
                        System.out.println("Your ticket booking is successfully completed!!!");
                        System.out.println("Take a print out!!!");
                        /*
                        Takes back to the main page and the ticket will be added to this profile........
                        */
                            }
                    else{
                        //Need to provide all passenger names and their personal details....
                        System.out.println("No of Co-passenger: ");
                        int noco = s.nextInt();
                        String [] pp = new String[noco];
                        for(int i=0;i<noco;i++){
                            System.out.println("Name:");
                            pp[i] = s.next();
                        }
                    }
                }
                else{
                System.out.println("From: ");
                String from = s.next();
                System.out.println("To: ");
                String to = s.next();
                d2.search_flight(from,to);
                    System.out.println("1.Choose a flight");
                    //System.out.println("2.Logout");
                    int next_mode = s.nextInt();
                    System.out.println("1.Buisness   2.Economic");
                    int be = s.nextInt();
                    System.out.println("Any Co-passenger: ");//need to press Y if yes N for no...
                    char c = s.next().charAt(0);
                    if(c=='N'){
                        System.out.println("Name: "+UserName);
                        System.out.println("TicketNumber:"+from.substring(0,2)+":"+to.substring(0,3)+""+random.nextInt(10));
                        if(be==1)System.out.println("Buisness");
                        else System.out.println("Economic");
                        System.out.println("Price:");
                        int price = s.nextInt();
                        System.out.println("Payment Modes:");
                        System.out.println("1.Debit Card");
                        System.out.println("2.Credit Card");
                        System.out.println("3.NET Banking");
                        int p_m = s.nextInt();
                        if(p_m == 1)System.out.println("Payed Using the Debit Card");
                        else if(p_m==2)System.out.println("Payed Using the Credit Card");
                        else System.out.println("Paid through Bank");
                        System.out.println("Your ticket booking is successfully completed!!!");
                        System.out.println("Take a print out!!!");
                        /*
                        Takes back to the main page and the ticket will be added to this profile........
                        */
                            }
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