package arc.ua.arcshop.model;

public enum AccountRole {
    ADMIN, USER, MODERATOR;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
