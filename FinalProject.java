import java.util.*;

public class FinalProject{

static Scanner read = new Scanner (System.in);

//==============================..MAIN..=================================================//

public static void main(String [] args)
{  
   int [] quantity = new int[100];
   int choice;
   int count=0;
   int []jumlah=new int[100];

   String [] nameBook = new String[100];
   
   do {
   menu();
   System.out.print("Please enter your choice:"); 
   choice=read.nextInt();
   
         if (choice==0){
          System.out.println("\n");
          System.out.println("Thank you and Bye..See you again"); 
         break;
         }
         else
         count=processChoice(nameBook,choice,count,quantity,jumlah);
         
   } while (choice !=0);
}//end main

//==============================..MENU..=================================================//

            static void menu(){
             System.out.println(":::::::: MENU GROCERY:::::::::\n"
                               +"1. Add Book\n"
                               +"2. Display Book\n"
                               +"3. Search for Book\n"
                               +"4. Edit Book Name\n"
                               +"5. Remove Book\n"
                               +"0. EXIT SYSTEM");
                               System.out.println("\n");

            }//menu
   
static int processChoice(String [] nameBook,int choice,int count,int []quantity,int []jumlah){

          switch(choice){
          
           case 1: count=addItem(nameBook,count,quantity,jumlah); break;
           case 2: display(nameBook,count,quantity,jumlah); break;
           case 3: search(nameBook,count); break;
           case 4: editItem(nameBook,count); break;
           case 5: count=removeItem(nameBook,count); break;
           
           default: System.out.println("Sorry your choice is not in the list. Please choose again.");
           }//switch
           
           return count;
         }//processChoice
         
//==============================..ADD BOOK..=================================================//

static int addItem(String [] nameBook,int count,int []quantity,int []jumlah){

      if (count < nameBook.length){
                    
                    System.out.print("Enter book ID (b1=Educational Book : b2=Novel :b3=Magazine):");
                    String id=read.nextLine();
                    id=read.nextLine();
                    
                    System.out.print("Enter book name :");
                    String nameBk=read.nextLine();

                    nameBook[count++]=nameBk;
                    
                    addQuantity(quantity);
                 
                    System.out.println("\n");
                    System.out.println("=====================================");
                 }
                 else
                   System.out.println("List is FULL.");
                   //display(nameBook,count);
                   
                 return count;
               }//addItem
               
//==============================..ADD BOOK QUANTITY..=================================================//

static void addQuantity(int []quantity){
int i=0;
//int k=0;

System.out.print("Enter book quantity :");
                    int jumlah=read.nextInt();

                    quantity[i]+=jumlah;
System.out.println("------------------------------------");
System.out.println("Total current book is :"+jumlah);
System.out.println("------------------------------------");                    
System.out.println("Total all book is :"+quantity[i]);

//return countQuantity;
}               
//==============================..SEARCH BOOK..=================================================//

static void search(String [] nameBook,int count){
                      
           boolean cari=false;
           
           if (count==0)
             System.out.println("Sorry list book is empty.");
             
           else {
             System.out.print("Search for book?:");
             String bk=read.nextLine();
             bk=read.nextLine();
              
             
                for (int i=0; i<count;i++){
                    if (nameBook[i].equals(bk)){
                    
                    cari=true;
                    System.out.println("\n");
                    System.out.println("Your search book is at location "+(i+1)+" in the list.");
                    System.out.println("\n");
                    System.out.println("=====================================");
                    
                    break;
                    }
                   }
                   
                if (cari==false)
                 System.out.println("Sorry your search book is not in the list.");
            }    
           }//end search
           
//==============================..VIEW BOOK..=================================================//
           
static void display(String [] nameBook,int count,int []quantity,int []jumlah){
int j=0;
//int k=0;
              if (count==0)
              System.out.println("Sorry list book is empty.");
              
              else
                 for (int i=0; i<count;i++)
                 System.out.println("Book "+(i+1)+":"+nameBook[i]);
                 System.out.println("\n");
                 
                 //for (int k=0; jumlah<count;k++)
                 //System.out.println("Quantity"+":"+jumlah[k]);
                 
                 System.out.println("=====================================");
                 System.out.println("Total all book is :"+quantity[j]);
                 System.out.println("=====================================");
              
              }//end display
              
//==============================..EDIT BOOK..=================================================//
              
static void editItem(String [] nameBook,int count){

  boolean cari=false;
  if (count==0)
         System.out.println("Sorry list book is empty.");
     else {
    System.out.print("Edit book name?:");
    String bk=read.nextLine();
    bk=read.nextLine();
    
    for (int i=0; i<count;i++){
     if (nameBook[i].equals(bk)){
          System.out.print("New book name?:");
          bk=read.nextLine();
          nameBook[i]=bk;
          cari=true;
          System.out.println("\n");
          System.out.println("=====================================");
          break;
          }
          
        }
        if (cari==false)
         System.out.println("Sorry your search book is not in the list.");
   }    
  }//end editItem              
//==============================..DELETE BOOK..=================================================//
              
static int removeItem(String [] nameBook,int count){
   int i,j;
   int bil=count;
   
   boolean delete=false;
         if (bil==0)
           System.out.println("Sorry list book is empty.");
           
              else {
              System.out.print("Book to be deleted?:");
              String bk=read.nextLine();
              bk=read.nextLine();
  
                 for ( i=0; i<bil;i++)
                    if (nameBook[i].equals(bk)){
                       for(j=i;j<count-1;j++)
                        nameBook[j]=nameBook[j+1];
                        --bil;
                        delete=true;
                        System.out.println("\n");
                        System.out.println("=====================================");
                        break;
                     }
                   }
                   
   if (delete==false)
   System.out.println("Sorry the book is not in the list.");
   return bil;
  }//end removeItem

}//end class