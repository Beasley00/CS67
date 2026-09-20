// Carter Beasley | Assignment 5 | TrainingSessions.java 

package Assignment6;

public abstract class TrainingSessions 
{
    // Attributes
    protected String startTime;
    protected String date;

    // Constructors
    public TrainingSessions(String startTime, String date) 
    {
        this.startTime = startTime;
        this.date = date;
    }

    // Getters and Setters
    public String getStartTime() 
    {
        return startTime;
    }

    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getDate() 
    {
        return date;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    @Override
    public String toString() 
    {
        return "Date: " + date + ", Start Time: " + startTime;
    }
}

