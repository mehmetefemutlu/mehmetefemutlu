public class labs01_Q3 
{
  public static void main(String[] args) 
    {

     final long AreaOfEarth = 510072000;
     final double AreaOfTurkey = AreaOfEarth*0.1538/100;
     double DryLandEarth = AreaOfEarth*29.2/100;
     int DryLandInTurkey =(int)AreaOfTurkey*76/77;
     int WaterInTurkey =(int)AreaOfTurkey/77;
     double WaterInEarth = AreaOfEarth*70.8/100;   
     double DryLandPercentageInTurkey = DryLandInTurkey/DryLandEarth*100;
     double WaterPercentageInTurkey = WaterInTurkey/WaterInEarth*100;
     
     
      System.out.println("Earth has " +(long)DryLandEarth + " km2 dry land and " +(long)WaterInEarth + " km2 water. ");
      System.out.println("Turkey has " +DryLandInTurkey + " km2 dry land and " +WaterInTurkey + " km2 water. ");
      System.out.println("Turkey has " +DryLandPercentageInTurkey + " percent of Earth's dry land. ");
      System.out.println("Turkey has " +WaterPercentageInTurkey + " percent of Earth's water. ");

    }

 
}
