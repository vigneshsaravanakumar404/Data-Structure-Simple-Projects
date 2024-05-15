class Vertex {

    final String name;
    String description;

    public Vertex(String name) {
        this.name = name;
    }

    public Vertex(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex) {
            Vertex v = (Vertex) obj;
            return this.name.equals(v.name);
        }
        return false;
    }

    @Override
    public String toString() {
        if (description != null) {
            return name + " (" + description + ")";
        } else {
            return name;
        }
    }

}