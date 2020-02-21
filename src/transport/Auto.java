package transport;

public class Auto extends AbstractVehicle
{

  private String model;
  private int year;

  public Auto(int fuel, String model, int year)
  {
    super(fuel);
    this.model = model;
    this.year = year;
  }

  @Override
  public String getPath()
  {
    return "Road";
  }

  @Override
  public String getName()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getYear()
  {
    return year;
  }

  @Override
  public String toString()
  {
    return "Auto{" +
            "model=" + model +
            ", year=" + year +
            ", fuel=" + fuel +
            '}';
  }

}