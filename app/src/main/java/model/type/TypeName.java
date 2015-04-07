package model.type;

public class TypeName {
    private String name;

    public TypeName(String name) {

        setName(name);

    }

    private String getName() {

        return this.name;

    }

    private void setName(String name) {

        this.name = name;

    }

    public void updateName(String name) {

        setName(name);

    }

    public String informName() {

        return getName();

    }

}
