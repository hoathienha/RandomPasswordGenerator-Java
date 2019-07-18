import java.io.*;
import java.util.*;
class Assign3
{
   public String generatePassword(String x)
   {
      Random rand = new Random();
      String password;
      char c1,c2,c3;
  
      c1 = x.charAt(0);
      
      int rNum = rand.nextInt(5) + 1;
      c3 = (char)(rNum + '0');
      
      char first = x.charAt(0);
      char last = x.charAt(x.length()-1); 
      int mid;
      
      if(first == last)
         mid = ((int)first + (int)last)/3;
      else
         mid = ((int)first + (int)last)/4;
        
      c2 = (char)(mid);  
      if(c2 == c3 || Character.isLetterOrDigit(c2) == false)
         c2 = '0';
       
      char c[] = {c1, c2};   
      password = String.valueOf(c) + rNum;
      return password.toLowerCase();
   }
   
   public void sortArrayAsc(String a[])
   {
      for(int i = 0; i < a.length - 1; i++)
         for(int j = i+1; j < a.length; j++)
            if(a[i].compareTo(a[j]) > 0)
            {
               String temp = a[i];
               a[i] = a[j];
               a[j] = temp;
            }
   }
   
   public void arrayDisplay(String a[], String b[])
   {
      for(int i = 0; i < a.length; i++)
         System.out.println(a[i] + " \t\t\t" + b[i]);
   }
   
   public int binSrch(String a[], String m)
   {
      int start = 0;
      int end = a.length - 1;
      int mid = -1;
      boolean found = false;
      
      m = m.trim();
      m = m.toLowerCase();
      
      while(start <= end)
      {
         mid = (start + end)/2;
         if(a[mid].compareTo(m) == 0)
         {
            found = true; 
            break;
         }
         else if(a[mid].compareTo(m) < 0)
               start = mid + 1;
         else end = mid - 1;    
      }
      if(!found)
         mid = -1;
      return mid;
   }
   
   public int search(String a[], String n)
   {
      for(int i = 0; i < a.length; i++)
         if(a[i].compareTo(n) == 0)
            return i;
      return -1;
   }
   
   public static void main(String args[])
   {
      Accept std = new Accept();
      Assign3 obj = new Assign3();
      String Iname[] = {"","","","",""};
      String psw[] = {"","","","",""};
      String x[] = {"","","","",""};
      String y[] = {"","","","",""};

      System.out.println("HOA THIEN HA Password Generator");
      System.out.println("Please enter 5 lastnames:");
      for(int i = 0; i < Iname.length; i++)
      {
         System.out.print("Please enter lastname:");
         Iname[i] = std.acceptInputString();
         Iname[i] = Iname[i].trim();
         Iname[i] = Iname[i].toLowerCase();
         x[i] = Iname[i];
         int a = 1;
         String t;
         do
         {
            t = obj.generatePassword(Iname[i]);
            t = t.trim();
            a = obj.search(psw, t);
            if(a != -1)
               System.out.println("duplicate password, regenerating");
            else
               psw[i] = t;
         }while(a != -1);
      }
         
      obj.sortArrayAsc(Iname);
      int temp = -1;
      for(int i = 0; i < x.length; i++)
      {
         temp = obj.search(x, Iname[i]);
         if(temp != -1)
            y[i] = psw[temp];
      }
      for(int i = 0; i < y.length; i++)
         psw[i] = y[i];

      obj.arrayDisplay(Iname, psw);
      Screen.scrollscreen("==================================", 1);
      
      String input;
      int index;
      do
      {
         System.out.print("Please enter name to search (0 to Exit): ");
         input = std.acceptInputString();
         input = input.trim();
         if(input.compareTo("0") != 0)
         {
            index = obj.binSrch(Iname, input);  
         
            if(index != -1)
               System.out.println("Name: " + Iname[index] + " ===> password: " + psw[index]);
            else
               System.out.println(input + " is not found");
            Screen.scrollscreen("+++++++++++++++++++", 1); 
         }
      }while(input.compareTo("0") != 0);
      Screen.scrollscreen(20);
   }
}