public class Package {
    String description;
    int weight;
    Package next;

    public Package(String description, int weight, Package next) {
        this.description = description;
        this.weight = weight;
        this.next = next;
    }

    public String toString() { //returns patient information
        return "Package Contents: " + description + " (" + weight + ")";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Package getNext() {
        return next;
    }

    public void setNext(Package next) {
        this.next = next;
    }
}