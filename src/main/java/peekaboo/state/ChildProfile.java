package peekaboo.state;


public class ChildProfile {
    private final String name;
    private final int age;
    private final String gender;
    private final String description;
    private final String location;
    private final String avatarFile; // filename of the PNG in resources/ui

    public ChildProfile(String name, int age, String gender, String description, String location, String avatarFile) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.location = location;
        this.avatarFile = avatarFile;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getAvatarFile() {
        return avatarFile;
    }
}