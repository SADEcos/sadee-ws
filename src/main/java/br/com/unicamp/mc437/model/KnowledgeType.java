package br.com.unicamp.mc437.model;


public enum KnowledgeType {
    JAVA("Java"),
    HTML("HTML"),
    C("C"),
    ANDROID("Android"),
    ANGULARJS("AngularJS"),
    PYTHON("Python"),
    BACKEND("Back End"),
    FRONTEND("Front End");

    private String description;

    KnowledgeType(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
