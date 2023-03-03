 import java.util.Scanner;
public class Main {
    static boolean isVaildCondo = false;
    static Scanner sc =new Scanner(System.in);
    public static void pressKey(){
        Scanner input = new Scanner(System.in);
        System.out.println(" \" Press Enter to continue...!\" ");
        input.nextLine();
    }
    public static void main(String[] args) {
        // Floor Validate
        boolean isfloorValid = false;
        // Room Validate
        boolean isRoomValid =false;
        String enter;
        int floorNum =0 , roomNum =0, op, floor=0,room=0,totalroom;
        String arr[][] = new String[floorNum][roomNum];
        boolean isValidCondo = false;
        String Cname = null;
        System.out.println("_______________ Setup the Condo(Floor and Room) _______________________");
        do{
            System.out.print(" -> Enter the number of Floor : ");
            floorNum=sc.nextInt();
            if(floorNum>-0 &&  0<floorNum){
                isVaildCondo =true;
            }else {
                System.out.println("\"Floor CANNOT ZERO OR NEGATIVE..!\"");
                isVaildCondo=false;
            }
        }while (!(isVaildCondo));
        do{
            System.out.print(" -> Enter the number of Room  : ");
            roomNum=sc.nextInt();
            if (roomNum>-0 && 0<roomNum){
                isVaildCondo = true;
            }else{
                System.out.println("\"ROOM CANNOT ZERO OR NEGATIVE..!\"");
                isVaildCondo=false;
            }
        }while(!(isVaildCondo));
        System.out.println("==================================");
        System.out.println("You successfully to Set up.");
        System.out.println("=> Number of Floor : "+floorNum);
        System.out.println("=> Number of Room : "+roomNum);
        totalroom = floorNum * roomNum;
        System.out.println("  Total Condo "+totalroom+" condo.");
        //! create Array 2D
        arr =new  String[floorNum][roomNum];
        for (int i=0; i<floorNum ;i++){
            for (int j=0 ;j<roomNum ;j++){
                arr[i][j] = null;
            }
        }
        do{
            System.out.println("=================== Welcome to Condo Phnom Penh  =========================");
            System.out.println(" 1-> Buy  Condo");
            System.out.println(" 2-> Sell Condo");
            System.out.println(" 3-> Search Information");
            System.out.println(" 4-> Display Information");
            System.out.println(" 5-> Exit");
            System.out.print(" Choose One Option : ");
            op=sc.nextInt();
            switch (op){
                case 1 ->{
                    System.out.println("=================Buy Condo==================");
                    do{
                        System.out.print("Enter your desired floor (1 -"+floorNum+"): ");
                        floor=sc.nextInt();
                        if (floorNum>0 && floor<=floorNum){
                            isfloorValid = true;
                            System.out.print("Enter your desired room (1 -"+roomNum+"): ");
                            room=sc.nextInt();
                            if (roomNum>0 && room<=roomNum){
                                isRoomValid = true;
                                if(isfloorValid && isRoomValid){
                                    if (arr[floor-1][room-1] == null){
                                        System.out.print("Enter your name : ");
                                        sc.nextLine();
                                        Cname=sc.nextLine();
                                        arr[floor-1][room-1] =Cname;
                                        System.out.println(Cname + " buying condo successfully.");
                                    }else{
                                        System.out.println("THIS CONDO HAS BEEN BY SOMEONE ELSE ALREADY.");
                                    }
                                }
                            }else{
                                System.out.println("FLOOR RANG START FORM (1-"+room+")");
                                isfloorValid = false;
                            }
                        }else{
                            System.out.println("ROOM RANG START FORM (1-"+floor+")");
                            isfloorValid = false;
                        }
                    }while (!isVaildCondo);
                }
                case 2 ->{
                    String name = null;
                    int key =1;
                    System.out.println("================= Selling the Condo back ==================");
                    System.out.print("Enter the Floor : ");
                    floor=sc.nextInt();
                    System.out.print("Enter the Room : ");
                    room=sc.nextInt();
                    if(floor>0 && floor<=floorNum){
                        if(room>0 && room<=roomNum){
                            if (arr[floor-1][room-1] !=null){
                                label:for (int i =(arr.length-1) ;i >= 0;i--){
                                    for (int j = 0; j<arr[i].length; j++){
                                        if(arr[floor-1][room-1] == arr[i][j]){
                                            arr[floor-1][room-1] = name;
                                            break label;
                                        }
                                    }
                                    //System.out.println("This room codon is sell successfully.");
                                    System.out.println(" Floor : " +floor+ "   Room : "+room+ "   Belong to " +Cname);
                                    System.out.println("========================================");
                                    System.out.println("Press 1 to Comfirm and 0 Cancel : ");
                                    key=sc.nextInt();
                                    if (key==1){
                                        arr[floor-1][room-1] = "<null>";
                                        System.out.println("CONGRATULATION !! YOU HAVE SUCCESSFULLY SELL YOUR CONDO.");
                                        break;
                                    }else{
                                        System.out.println("YOU CANNOT SELL THIS CONDO...!");
                                        break label;
                                    }
                                }
                            }else{
                                System.out.println("CANNOT SELL THE CONDO CAUSE YOU DON'T HAVE THE OWNERSHIP..!");
                            }
                        }
                    }
                }
                case 3 ->{
                    boolean isVaildCondo = false;
                    int Sfloor;
                    String Sname;
                    int option;
                    do{
                        System.out.println("================= Search Condos ==============");
                        System.out.println("1. Search by owner's name ");
                        System.out.println("2. Search by floor ");
                        System.out.println("3. Exit");
                        System.out.println("---------------------------");
                        System.out.print("Choose one otpion (1-3) : ");
                        option=sc.nextInt();
                        switch (option){
                            case 1->{
                                System.out.println("------------------ Search Information -----------------------");
                                System.out.print("Pleas enter owner's name : ");
                                Sname=sc.next();
                                    for (int i =0;i<arr.length;i++) {
                                        for (int j = 0; j < arr[i].length; j++) {
                                            if (Sname.equals(arr[i][j])) {
                                                isVaildCondo = true;
                                                System.out.println("Owner Name : "+arr[i][j]+ " stays in Room No : "+(j+1)+ " Floor No : "+(i+1));
                                            }
                                    }

                                }
                                if(!isVaildCondo){
                                    System.out.println("User : " + Sname + " doesn't exits in our condo system");
                                    break;
                                }
                            }
                            case 2 ->{
                                System.out.println("------------------ Search Information -----------------------");
                                System.out.print(" => Pleas Enter of floor you want to search  : ");
                                Sfloor=sc.nextInt();
                                if (Sfloor == floor){
                                    System.out.println("Here are the information of the floor "+Sfloor);
                                    for (int i =0 ;i < Sfloor;i++){
                                       System.out.print("Floor [" + (i+1) + "] =>  ");
                                        for (int j = 0; j< arr[i].length; j++){
                                            System.out.print(arr[i][j]+ "   ");
                                            break;
                                        }
                                        System.out.println("");
                                    }
                                }
                            }
                            case 3->System.exit(0);
                        }
                        pressKey();
                    }while(!(isVaildCondo));
                }
                case 4->{
                    System.out.println("=================Dispaly Information==================");
                    for (int i =(arr.length-1) ;i >= 0;i--){
                        System.out.print("Floor  [" + (i+1) + "] =>  ");
                        for (int j = 0; j<arr[i].length; j++){
                            System.out.print(arr[i][j]+ "   ");
                        }
                        System.out.println("");
                    }
                }
                case 5->{
                    System.out.print(" Good Bye See you next time...");
                    System.exit(0);
                }
            }
            pressKey();
        }while(!(isValidCondo));
    }
}