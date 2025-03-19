package compulsory;

public abstract class Aircraft implements Comparable<Aircraft> {
    protected String model;
    protected String tailNumber;

    public Aircraft(String model, String tailNumber) {
        this.model = model;
        this.tailNumber = tailNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }


    public String getModel() {
        return model;
    }

    @Override
    public int compareTo(Aircraft other) {
        if (this.model == null) return -1;
        return this.model.compareTo(other.model);
    }

    @Override
    public String toString() {
        return "Model: " + model + ", Tail Number: " + tailNumber;
    }
}