package sescheraun.worldoffuturedarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The user bean
 *
 * @author Robert Collier
 */
@Entity(name="User")
@Table(name="user")
public class User {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    private String firstName;

    private String lastName;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();


    private String userName;

    private boolean isDeleted;

    private String authenticator;

    private String emailAddress;

    private String phoneNumber;

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets authenticator.
     *
     * @return the authenticator
     */
    public String getAuthenticator() {
        return authenticator;
    }

    /**
     * Sets authenticator.
     *
     * @param authenticator the authenticator
     */
    public void setAuthenticator(String authenticator) {
        this.authenticator = authenticator;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Is deleted boolean.
     *
     * @return the boolean
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void addRole (Role role) {
        role.setUser(this);
        roles.add(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                isDeleted == user.isDeleted &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(authenticator, user.authenticator) &&
                Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, userName, isDeleted, authenticator, emailAddress, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
