import java.time.LocalDate;

public class Person {
    private String name;
    private String pNumber;
    private LocalDate trainingDate;

    public Person(String name, String personalNumber, LocalDate trainingDate){
        this.name = name;
        this.pNumber = personalNumber;
        this.trainingDate = trainingDate;
    }
    public String getName(){
        return name;
    }
    public String getPersonalNumber(){
        return pNumber;
    }
    public LocalDate getTrainingDate(){
        return trainingDate;
    }

}
