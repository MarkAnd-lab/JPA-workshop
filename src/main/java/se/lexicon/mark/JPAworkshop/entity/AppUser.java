package se.lexicon.mark.JPAworkshop.entity;

import javax.persistence.Entity;
import java.util.Objects;

public class AppUser {

    private int appUserId;
    private String firstName;
    private String lastName;
    private String email;

    //This is needed. Every entity MUST HAVE a default or empty constructor.
    public AppUser() {}

    public AppUser(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public AppUser(int appUserId, String firstName, String lastName, String email) {
        this(firstName, lastName, email);
        this.appUserId = appUserId;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return appUserId == appUser.appUserId &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(email, appUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, firstName, lastName, email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppUser{");
        sb.append("appUserId=").append(appUserId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
