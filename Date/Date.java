public class Date{

	private int year;
	private int month;
	private int day;

	private boolean divBy100 = false;
	private boolean divBy400 = false;
	private boolean divBy4 = false;
	private boolean leap = false;


   public Date(){
      year = 1000;
      month = 1;
      day = 1;
   }

   public Date(int year, int month, int day){
      this.year = year;
      this.month = month;
      this.day = day;
   }

   public int getYear(){
      return this.year;
   }

   public int getMonth(){
      return this.month;
   }

   public int getDay(){
      return this.day;
   }

   public void setYear(int year){
      
      if(year>9999 || year<1000){
         throw new IllegalArgumentException("Input of year is unaaceptable !");
      }

      else{
         this.year = year;
      }

      if (year%100 == 0){
         this.divBy100 = true;
      }

      if (year%400 == 0){
         this.divBy400 = true;
      }

      if(year%4==0){
         this.divBy4 = true;
      }

      if (divBy100 && divBy400){
         this.leap = true;
      }

      if (year%100!=0  && divBy4){     //divBy100 = false
         this.leap = true;
      }
   
   }

   public void setMonth(int month){
      
      if(month<1 || month>12){
         throw new IllegalArgumentException("Input of month is unaaceptable !");
      }

      else{
         this.month = month;
      }
   }

   public void setDay(int day){

      if(day<1 || day>31){       //for all months
         throw new IllegalArgumentException("Input of day is unaaceptable! Note: leap year...");
      }

      if (this.month == 2){      //february

         if(leap){
            if(day>29){
               throw new IllegalArgumentException("Input of day is unaaceptable! Note: leap year...");
            }
         }

         else{
            if(day>28){
               throw new IllegalArgumentException("Input of dayfor February is unaaceptable !");
            }
         }

      }

      if(day>30 && (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)){   //4, 6, 9, 11 == 30 days
         throw new IllegalArgumentException("Input of day for this month must be 1-30 inclusive!");
      }
      this.day = day;      
   }

   public String toString(){
      return String.format("%02d//%02d//%d", this.month, this.day, this.year);
   }

   public void setDate(int year, int month, int day){
      this.year = year;
      this.month = month;
      this.day = day;
   }

}
